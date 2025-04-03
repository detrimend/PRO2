public class OffState implements CarState
{
  public void click(BillysCar car)
  {
    // ingen kørsel, lys slukket
    if (car.haveLightsSwitched() == false)
    {
      car.setState(new LightsOnState());
      car.turnOnLights();
    }
    else if (car.isLastDriveForward() == false && car.haveLightsSwitched() == true)
    {
      car.setState(new ForwardState());
      car.driveForward();
      car.turnOnLights();
    }
    else if (car.isLastDriveForward() == true && car.haveLightsSwitched() == true)
    {
      car.setState(new BackwardState());
      car.driveBackward();
      car.turnOnLights();
    }

  }
}
