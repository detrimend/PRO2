public class Burgerbar
{
  private int numberOfBurgers;
  private int maxNumberOfBurgers;

  public Burgerbar(int maxNumberOfBurgers)
  {
    this.numberOfBurgers = 0;
    this.maxNumberOfBurgers = maxNumberOfBurgers;
  }

  public synchronized void makeBurger()
  {
    while (numberOfBurgers >= maxNumberOfBurgers)
    {
      System.out.println("Waiting " + Thread.currentThread().getName() + " "
          + numberOfBurgers);
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    numberOfBurgers++;
    notifyAll();
    System.out.println("Burger made by " + Thread.currentThread().getName()
        + ". Current number of burgers: " + numberOfBurgers);

  }

  public synchronized void eatBurger()
  {
    while (numberOfBurgers <= 0)
    {
      System.out.println("Waiting " + Thread.currentThread().getName()
          + ". Number of burgers: " + numberOfBurgers);
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    numberOfBurgers--;
    notifyAll();
    System.out.println("Burger ate by " + Thread.currentThread().getName()
        + ". Current number of burgers: " + numberOfBurgers);
  }

  public synchronized int getNumberOfBurgers()
  {
    return numberOfBurgers;
  }
}
