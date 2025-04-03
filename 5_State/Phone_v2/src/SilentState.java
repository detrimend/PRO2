public class SilentState implements AlertState
{
  public SilentState(Phone phone)
  {
    phone.setMinimumVolume();
  }
  public void click(Phone phone)
  {
    phone.setState(new SoundState());
  }

  public String alert()
  {
    return "[silent]";
  }

  public void volumeUp(Phone phone)
  {

  }
}
