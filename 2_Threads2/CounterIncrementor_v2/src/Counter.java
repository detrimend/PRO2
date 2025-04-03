public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min, long max)
  {
    this.value = 0;
    this.max = max;
    this.min = min;
  }

  public synchronized void increment()
  {
    while (value >= max)
    {
      System.out.println("Waiting " + Thread.currentThread().getName() + " " + value);
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    value++;
    notifyAll();
    System.out.println("Incremented by " + Thread.currentThread().getName() + " " + value);

  }

  public synchronized void decrement()
  {
    while (value <= min)
    {
      System.out.println("Waiting " + Thread.currentThread().getName() + " " + value);
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        //...
      }
    }
    value--;
    notifyAll();
    System.out.println("Decremented by " + Thread.currentThread().getName() + " " + value);
  }

  public synchronized long getValue()
  {
    return value;
  }
}
