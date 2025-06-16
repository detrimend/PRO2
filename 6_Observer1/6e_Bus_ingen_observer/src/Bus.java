import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Bus
{
  private String info;
  private Set<BusPassenger> passengers;

  public Bus()
  {
    passengers = new HashSet<BusPassenger>();
    this.info = "eXpress " + hashCode() % 100;
  }

  public void passengerGettingIn(BusPassenger p)
  {
    Iterator<BusPassenger> it = passengers.iterator();
    while (it.hasNext())
      it.next().showMessage("Enter:" + p.getName());
    passengers.add(p);
  }

  public void passengerGettingOut(BusPassenger p)
  {
    passengers.remove(p);
    Iterator<BusPassenger> it = passengers.iterator();
    while (it.hasNext())
      it.next().showMessage("Leave:" + p.getName());
  }

  public String getInfo()
  {
    return info;
  }

  public String getPassengerList()
  {
    StringBuilder sb = new StringBuilder();
    Iterator<BusPassenger> it = passengers.iterator();
    while (it.hasNext())
    {
      sb.append(it.next().getName());
      if (it.hasNext())
        sb.append(", ");
    }
    return sb.toString();
  }

  public String toString()
  {
    return "Bus " + info + " with passengers: " + getPassengerList();
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Bus))
      return false;
    Bus b = (Bus) obj;
    return info.equals(b.info);
  }
}