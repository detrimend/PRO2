public abstract class AlertState
{
  public abstract void click(Phone phone);
  public abstract String alert();

  public void volumeUp(Phone phone)
  {
    phone.incrementVolume();
  }
  public void volumeDown(Phone phone)
  {
    phone.decrementVolume();
  }
}
