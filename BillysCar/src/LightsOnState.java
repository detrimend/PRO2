public class LightsOnState implements CarState
{
  public void click(BillysCar car)
  {
    // ingen kørsel, lys tændt
    car.setState(new OffState());
    car.turnOffLights();
  }
}