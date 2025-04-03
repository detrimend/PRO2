public class CounterDecrementor implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterDecrementor(Counter counter, int updates)
  {
    this.counter = counter;
    this.updates = updates;
  }

  public void run()
  {
    for(int i = 0; i < updates; i++)
    {
      counter.decrement();
    }
    System.out.println(counter.getValue());
  }
}
