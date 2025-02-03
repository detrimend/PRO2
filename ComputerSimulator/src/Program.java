public class Program implements Runnable
{
  private String program;
  private String action;
  private int count;
  private static final long RUNTIME = 100000;

  public Program(String program, String action, int count)
  {
    this.program = program;
    this.action = action;
    this.count = count;
  }

  private void normalOperation()
  {
    try
    {
      Thread.sleep(RUNTIME / count);
    }
    catch (InterruptedException e)
    {
      // do nothing
    }
  }

  public void run()
  {
    for (int i = 0; i < count; i++)
    {
      System.out.println(action);
      normalOperation();
    }
  }
}
