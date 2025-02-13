public abstract class DoorState
{
  public abstract void click(Door door);

  public void complete(Door door)
  {
    // nothing
  }

  public void timeout(Door door)
  {
    // nothing
  }

  public String status()
  {
    return getClass().getSimpleName();
  }
}
