public class Main
{
  public static void main(String[] args)
  {
    BlockingQueue<String> queue = new BlockingQueue<>(5);


    new Thread(() -> {
      System.out.println("Producer 1 started");
      while (true)
      {
        String item = "Item " + System.currentTimeMillis();
        queue.put(item);
        //System.out.println("P1 produced: " + item);
        try
        {
          Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();


    new Thread(() -> {
      System.out.println("Producer 2 started");
      while (true)
      {
        String item = "Item " + System.currentTimeMillis();
        queue.put(item);
        //System.out.println("P2 produced: " + item);
        try
        {
          Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();


    new Thread(() -> {
      System.out.println("Consumer 1 started");
      while (true)
      {
        String item = queue.take();
        System.out.println("C1 consumed: " + item);
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();


    new Thread(() -> {
      System.out.println("Consumer 2 started");
      while (true)
      {
        String item = queue.take();
        System.out.println("C2 consumed: " + item);
        try
        {
          Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }).start();


    /*
    try
    {
      producer.join();
      consumer.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

     */
  }
}
