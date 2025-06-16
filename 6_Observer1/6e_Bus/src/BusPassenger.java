import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BusPassenger implements PropertyChangeListener
{
  private String name;
  private Bus bus;
  private boolean newPassenger;

  public BusPassenger(String name)
  {
    this.name = name;
    this.bus = null;
    this.newPassenger = false;
  }

  public String getName()
  {
    return name;
  }

  public boolean isNewPassenger()
  {
    return newPassenger;
  }

  public Bus getBus()
  {
    return bus;
  }

  public void getIn(Bus bus)
  {
    if (this.bus != null)
      getOut();
    this.bus = bus;
    newPassenger = true;
    bus.passengerGettingIn(this);
    bus.addListener(this);
  }

  public void getOut()
  {
    newPassenger = false;
    bus.passengerGettingOut(this);
    bus.removeListener(this);
    bus = null;
  }

  public String toString()
  {
    return name;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof BusPassenger))
      return false;
    BusPassenger p = (BusPassenger) obj;
    return name.equals(p.name) && ((bus == null & p.bus == null) || bus.equals(
        p.bus)) && newPassenger == p.newPassenger;
  }

  public void showMessage(String message)
  {
    String reply = "";
    String[] split = message.split(":");
    if (split.length != 2)
    {
      reply = "I don't understand";
    }
    else
    {
      if (split[0].equalsIgnoreCase("Enter"))
        reply = "Hello ";
      else
        reply = "Bye Bye ";
      reply += split[1];
    }
    System.out.println(name + "> " + reply);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("passengerGettingIn"))
    {
      BusPassenger p = (BusPassenger) evt.getNewValue();
      if (p != this)
      {
        showMessage("Enter:" + p.getName());
      }
    }
    else if (evt.getPropertyName().equals("passengerGettingOut"))
    {
      BusPassenger p = (BusPassenger) evt.getNewValue();
      if (p != this)
      {
        showMessage("Leave:" + p.getName());
      }
    }
  }
}