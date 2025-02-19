public class BillysCar
{
  private boolean lastDriveForward;
  private boolean haveLightsSwitched;
  private CarState state;

  public BillysCar()
  {
    this.lastDriveForward = false;
    this.haveLightsSwitched = true;
    this.state = new OffState();
  }

  public void click()
  {
    state.click(this);
  }

  public void setState(CarState newState)
  {
    this.state = newState;
  }

  public boolean isLastDriveForward()
  {
    return lastDriveForward;
  }

  public boolean haveLightsSwitched()
  {
    return haveLightsSwitched;
  }

  public void driveForward()
  {
    lastDriveForward = true;
  }

  public void driveBackward()
  {
    lastDriveForward = false;
  }

  public void turnOnLights()
  {
    haveLightsSwitched = false;
  }

  public void turnOffLights()
  {
    haveLightsSwitched = true;
  }

  // til test, var ikke i diagram SuperMad :/
  public String status()
  {
    String driveDirection = lastDriveForward ? "Driving Forward" : "Driving Backward";
    String lightsStatus = haveLightsSwitched ? "Lights Off" : "Lights On";
    return state.getClass().getSimpleName() + " - " + driveDirection + " - " + lightsStatus;
  }

}
