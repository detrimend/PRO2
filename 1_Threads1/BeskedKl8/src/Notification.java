import java.time.Duration;
import java.time.LocalTime;

public class Notification implements Runnable
{
  private LocalTime scheduledTime;

  public Notification()
  {
    // this.scheduledTime = LocalTime.of(8,0);
    this.scheduledTime = LocalTime.now().plusSeconds(20);
  }

  public void run()
  {
    while (true)
    {
      LocalTime time = LocalTime.now();
      Duration duration = Duration.between(time, scheduledTime);
      long diff = duration.toMillis();
      System.out.println(diff);
      if (time.isAfter(scheduledTime))
      {
        System.out.println("hello, it's after 8 :)");
        diff += 86400000;
      }

      try
      {
        Thread.sleep(diff);
      }
      catch (InterruptedException e)
      {
        // do nothing
      }

    }
  }
}
