public class SoundState implements AlertState
{
  public void click(Phone phone)
  {
    phone.setState(new VibrationState());
  }

  public String alert()
  {
    return "DRIIIING";
  }
}
