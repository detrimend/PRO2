public class Main
{
  public static void main(String[] args)
  {
    CookieJar jar = new CookieJar(32, 5, 16);
    Thread baker = new Thread(new CookieBaker(jar));
    Thread eater1 = new Thread(new CookieEater(jar));
    Thread eater2 = new Thread(new CookieEater(jar));
    Thread eater3 = new Thread(new CookieEater(jar));

    baker.start();
    eater1.start();
    eater2.start();
    eater3.start();

    try
    {
      baker.join();
      eater1.join();
      eater2.join();
      eater3.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
