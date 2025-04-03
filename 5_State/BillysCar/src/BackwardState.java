public class BackwardState implements CarState
{
  public void click(BillysCar car)
  {
    // bakker, lys tændt
    car.setState(new OffState());
    car.turnOffLights();
  }
}