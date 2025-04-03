public class SilentState implements AlertState
{
  public void click(Phone phone)
  {
    phone.setState(new SoundState());
  }

  public String alert()
  {
    return "[silent]";
  }
}
