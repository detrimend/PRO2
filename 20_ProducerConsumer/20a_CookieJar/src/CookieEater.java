public class CookieEater implements Runnable
{
  private CookieJar jar;

  public CookieEater(CookieJar jar)
  {
    this.jar = jar;
  }

  @Override public void run()
  {
    while (true)
    {
      jar.eat();
      spendSomeTime("eating cookies");
    }
  }

  private void spendSomeTime(String what)
  {
    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
