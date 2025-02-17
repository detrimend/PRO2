package external;

import javafx.application.Platform;
import view.TemperatureViewController;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable, UnnamedPropertyChangeSubject
{
  private DateTimeFormatter timeFormatter;
  private PropertyChangeSupport property;

  public RunnableClock()
  {
    this.timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    this.property = new PropertyChangeSupport(this);
  }

  public void run()
  {
    while (true)
    {
      LocalTime time = LocalTime.now();
      String timeString = time.format(timeFormatter);
      System.out.println(timeString);
      property.firePropertyChange("Time","nothing",timeString);
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        // do nothing
      }
    }
  }

  public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
