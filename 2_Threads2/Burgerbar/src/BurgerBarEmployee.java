public class BurgerBarEmployee implements Runnable
{
  private String name;
  private Burgerbar burgerbar;

  public BurgerBarEmployee(String name, Burgerbar burgerbar)
  {
    this.name = name;
    this.burgerbar = burgerbar;
  }

  public void run()
  {
    while (true)
    {
      burgerbar.makeBurger();
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
  }
}
