public class ToiletBuilding implements PublicToilet
{
  private int people;
  private int cleaners;
  private int waitingCleaners;;

  public ToiletBuilding()
  {
    people = 0;
    cleaners = 0;
    waitingCleaners = 0;
  }

  @Override public synchronized void stepIntoCabin()
  {
    while (cleaners > 0 || waitingCleaners > 0)
    {
      System.out.println(Thread.currentThread() + " waiting for cleaners to finish");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }

  }

  @Override public synchronized void leaveCabin()
  {

  }

  @Override public synchronized void startCleaning()
  {
    waitingCleaners++;
    while (people > 0 || cleaners > 0)
    {
      System.out.println(Thread.currentThread() + " waiting for people to finish");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //
      }
    }
    waitingCleaners--;
    cleaners++;
    System.out.println(Thread.currentThread() + " started cleaning");
  }

  @Override public synchronized void endCleaning()
  {

  }
}
