import java.util.ArrayList;

public class CookieJar
{
  private int cookieCountWhenToBake;
  private int numberOfCookiesInTheOven;
  private int cookiePlateSize;
  private ArrayList<Cookie> cookies;

  public CookieJar(int jarSize, int cookieCountWhenToBake, int cookiePlateSize)
  {
    this.cookieCountWhenToBake = cookieCountWhenToBake;
    this.cookiePlateSize = cookiePlateSize;
    this.numberOfCookiesInTheOven = 0;
    this.cookies = new ArrayList<>(jarSize);
  }

  public synchronized void startBaking()
  {
    while (cookies.size() >= cookieCountWhenToBake)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    numberOfCookiesInTheOven = cookiePlateSize;
  }

  public synchronized void finishedBaking()
  {
    for (int i = 0; i < numberOfCookiesInTheOven; i++)
    {
      cookies.add(new Cookie("chocolate chip"));
    }
    numberOfCookiesInTheOven = 0;
    notifyAll();
  }

  public synchronized void eat()
  {
    while (cookies.isEmpty())
    {
      System.out.println("No cookies in the jar :(");
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    Cookie cookie = cookies.remove(0);
    System.out.println("Eating " + cookie.getType() + " cookie");
    if (cookies.size() < cookieCountWhenToBake)
    {
      System.out.println("Less than " + cookieCountWhenToBake + " cookies in the jar");
      notify();
    }
  }

}
