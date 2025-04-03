public class Burgerbar
{
  private int numberOfBurgers;
  private int maxNumberOfBurgers;
  private int nextNumberToTake; //fair
  private int nextNumberToServe; //fair

  public Burgerbar(int maxNumberOfBurgers)
  {
    this.numberOfBurgers = 0;
    this.maxNumberOfBurgers = maxNumberOfBurgers;
    this.nextNumberToTake = 1; //fair
    this.nextNumberToServe = 1; //fair
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
    int myNumber = nextNumberToTake; //fair
    nextNumberToTake++; //fair
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
