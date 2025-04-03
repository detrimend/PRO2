import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queue;

  public BlockingQueue(int capacity)
  {
    queue = new BoundedArrayQueue<>(capacity);
  }

  @Override public synchronized void put(T element)
  {
    if (element == null)
    {
      throw new IllegalArgumentException("Element cannot be null");
    }

    while (queue.isFull())
    {
      System.out.println("Queue is full, waiting to put element: " + element);
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    queue.enqueue(element);
    System.out.println("Element added to queue: " + element);
    notify();
  }

  @Override public synchronized T take()
  {
    while (queue.isEmpty())
    {
      System.out.println("Queue is empty, waiting to take element");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    T element = queue.dequeue();
    System.out.println("Element removed from queue: " + element);
    notify();
    return element;
  }

  @Override public synchronized T look()
  {
    if (queue.isEmpty())
    {
      return null;
    }
    return queue.first();
  }

  @Override public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }
}
