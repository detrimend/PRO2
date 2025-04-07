import java.util.ArrayDeque;
import java.util.Queue;

public class ListAccess implements ReadWriteAccess
{
  private int readers;
  private int writers;
  private Queue<Thread> queue;
  private HeavyWeightList list;

  public ListAccess(HeavyWeightList list)
  {
    this.list = list;
    readers = 0;
    writers = 0;
    queue = new ArrayDeque<>();
  }

  @Override public synchronized ReadList acquireRead()
  {
    System.out.println(Thread.currentThread() + " requesting read access");
    queue.offer(Thread.currentThread());
    while (queue.peek() != Thread.currentThread())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }
    while (writers > 0)
    {
      System.out.println(Thread.currentThread() + " waiting for writers to finish");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }
    System.out.println(Thread.currentThread() + " granted read access");
    readers++;
    queue.remove();
    notifyAll(); // notify readers waiting for their turn
    ReadList readList = list;
    return readList;
  }

  @Override public synchronized void releaseRead()
  {
    System.out.println(Thread.currentThread() + " releasing read access");
    readers--;
    if (readers == 0)
    {
      notifyAll();
    }
  }

  @Override public synchronized ReadWriteList acquireWrite()
  {
    System.out.println(Thread.currentThread() + " requesting write access!!!!!!!!!!!!!");
    queue.offer(Thread.currentThread());
    while (queue.peek() != Thread.currentThread())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }
    while (readers > 0 || writers > 0)
    {
      System.out.println(Thread.currentThread() + " waiting for readers and writers to finish");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }
    System.out.println(Thread.currentThread() + " granted write access!!!!!!!!!!!!!");
    writers++;
    queue.remove();
    notifyAll();
    ReadWriteList writeList = list;
    return writeList;
  }

  @Override public synchronized void releaseWrite(int l)
  {
    System.out.println(Thread.currentThread() + " releasing write access");
    writers--;
    notifyAll();
  }
}
