import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Bus implements UnnamedPropertyChangeSubject
{
  private String info;
  private PropertyChangeSupport property;

  public Bus()
  {
    this.info = "eXpress " + hashCode() % 100;
    property = new PropertyChangeSupport(this);
  }

  public void passengerGettingIn(BusPassenger p)
  {
    property.firePropertyChange("passengerGettingIn", null, p);
  }

  public void passengerGettingOut(BusPassenger p)
  {
    property.firePropertyChange("passengerGettingOut", null, p);
  }

  public String getInfo()
  {
    return info;
  }

  public String toString()
  {
    return "Bus " + info + " with " + (property.getPropertyChangeListeners().length) + " passengers";
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Bus))
      return false;
    Bus b = (Bus) obj;
    return info.equals(b.info);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}