import java.util.ArrayList;

public class Adding implements Runnable
{
  private String id;
  private long sleepTime;
  private ArrayList<String> list;

  public Adding(ArrayList<String> list, String id, long sleepTime)
  {
    this.list = list;
    this.id = id;
    this.sleepTime = sleepTime;
  }

  public void run()
  {
    for (int i = 0; i < 5; i++)
    {
      list.add(id + "#" + i);
      try
      {
        Thread.sleep(sleepTime);
      }
      catch (InterruptedException e)
      {
        // do nothing
      }
    }
  }
}
