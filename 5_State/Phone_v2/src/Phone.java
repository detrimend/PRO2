public class Phone
{
  private AlertState state;
  private static final int MIN_VOLUME = 0;
  private static final int MAX_VOLUME = 10;
  private int volume;

  public Phone()
  {
    state = new SilentState(this);
  }

  public void clickSoundButton()
  {
    state.click(this);
  }

  public void volumeUp()
  {
    state.volumeUp(this);
  }

  public void volumeDown()
  {
    state.volumeDown(this);
  }

  public int getVolume()
  {
    return volume;
  }

  public void receive(String message)
  {
    System.out.println(state.alert());
    System.out.println(message);
  }

  public void setState(AlertState state)
  {
    this.state = state;
  }

  public void incrementVolume()
  {
    if (volume < MAX_VOLUME)
    {
      volume++;
    }
  }

  public void decrementVolume()
  {
    if (volume > MIN_VOLUME)
    {
      volume--;
    }
  }

  public void setMinimumVolume()
  {
    volume = MIN_VOLUME;
  }

  public void setMediumVolume()
  {
    volume = (MAX_VOLUME - MIN_VOLUME) / 2;
  }

  public String status()
  {
    return state.getClass().getSimpleName() + " with volume " + volume;
  }
}
