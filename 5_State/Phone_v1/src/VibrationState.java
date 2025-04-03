public class VibrationState implements AlertState
{
  public void click(Phone phone)
  {
    phone.setState(new SilentState());
  }

  public String alert()
  {
    return "BRZZ BRZZ";
  }
}
