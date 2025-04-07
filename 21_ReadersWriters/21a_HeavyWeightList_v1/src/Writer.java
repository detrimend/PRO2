public class Writer implements Runnable
{
  private ReadWriteAccess lock;

  public Writer(ReadWriteAccess lock)
  {
    this.lock = lock;
  }

  @Override
  public void run()
  {
    for (int i = 0; i < 3; i++)
    {
      spendSomeTime(5000, 10000);
      ReadWriteList list = lock.acquireWrite();
      list.write(0);
      lock.releaseWrite(0);
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
