public class CookieBaker implements Runnable
{
  private CookieJar jar;

  public CookieBaker(CookieJar jar)
  {
    this.jar = jar;
  }

  @Override public void run()
  {
    while (true)
    {
      jar.startBaking();
      spendSomeTime("baking cookies");
      jar.finishedBaking();
      System.out.println("Baker finished baking cookies");
    }
  }

  private void spendSomeTime(String what)
  {
    System.out.println("Baker is " + what);
    try
    {
      Thread.sleep(20000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
