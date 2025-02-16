public class Phone
{
  private AlertState state;
  private static final int MIN_VOLUME = 0;
  private static final int MAX_VOLUME = 10;
  private int volume;

  public Phone()
  {
    state = new SilentState();
  }

  public void clickSoundButton()
  {
    state.click(this);
  }

  public void setState(AlertState state)
  {
    this.state = state;
  }

  public void receive(String message)
  {
    System.out.println(state.alert());
    System.out.println(message);
  }

  public String status()
  {
    return state.getClass().getSimpleName();
  }
}
