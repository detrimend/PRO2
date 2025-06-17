public class SoundState extends AlertState
{
  @Override public void click(Phone phone)
  {
    phone.setState(new VibrationState());
  }

  @Override public String alert()
  {
    return "DRIIIING";
  }

  @Override public void volumeDown(Phone phone)
  {
    if (phone.getVolume() == 1)
    {
      phone.setState(new SilentState(phone));
    }
    phone.decrementVolume();
  }
}
