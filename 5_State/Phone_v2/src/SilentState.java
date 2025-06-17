public class SilentState extends AlertState
{
  public SilentState(Phone phone)
  {
    phone.setMinimumVolume();
  }

  @Override public void click(Phone phone)
  {
    phone.setState(new SoundState());
    phone.setMediumVolume();
  }

  @Override public String alert()
  {
    return "[silent]";
  }

  @Override public void volumeUp(Phone phone)
  {
    phone.setState(new SoundState());
    phone.incrementVolume();
  }
}
