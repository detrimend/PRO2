package external;

public class RunnableClockTest
{
  public static void main(String[] args)
  {
    RunnableClock runnableClock = new RunnableClock();

    Thread thread = new Thread(runnableClock);

    thread.start();
  }
}
