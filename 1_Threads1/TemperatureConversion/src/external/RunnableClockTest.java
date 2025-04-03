package external;

public class RunnableClockTest
{
  public static void main(String[] args)
  {
    RunnableClock runnableClock = new RunnableClock(null);

    Thread thread = new Thread(runnableClock);

    thread.start();
  }
}
