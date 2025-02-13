public class Door
{
  private DoorState state;

  public Door()
  {
    state = new DoorClosed();
  }

  public void click()
  {
    state.click(this);
    //System.out.println(status());
  }

  public void complete()
  {
    state.complete(this);
  }

  public void setState(DoorState state)
  {
    this.state = state;
    //System.out.println(status());
  }

  public String status()
  {
    return state.getClass().getSimpleName();
  }

  public void timeout()
  {
    state.timeout(this);
  }
}
