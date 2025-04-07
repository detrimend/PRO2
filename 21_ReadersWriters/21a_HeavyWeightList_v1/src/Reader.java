public class Reader implements Runnable
{
  private ReadWriteAccess lock;

  public Reader(ReadWriteAccess lock)
  {
    this.lock = lock;
  }

  @Override
  public void run()
  {
    for (int i = 0; i < 3; i++)
    {
      spendSomeTime(1000, 10000);
      ReadList list = lock.acquireRead();
      list.read();
      lock.releaseRead();
    }
  }

  private void spendSomeTime(int minTime, int maxTime)
  {
    int time = (int) (Math.random() * (maxTime - minTime + 1)) + minTime;
    try
    {
      Thread.sleep(time);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
