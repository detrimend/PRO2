public class CounterIncrementor implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterIncrementor(Counter counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  public void run()
  {
    for(int i = 0; i < 200000; i++)
    {
      counter.increment();
    }
    System.out.println(counter.getValue());
  }
}
