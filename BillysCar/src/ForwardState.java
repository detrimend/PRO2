public class ForwardState implements CarState
{
  public void click(BillysCar car)
  {
    // kører fremad, lys tændt
    car.setState(new OffState());
    car.turnOffLights();
  }
}