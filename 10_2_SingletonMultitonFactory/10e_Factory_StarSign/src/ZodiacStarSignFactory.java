public class ZodiacStarSignFactory extends StarSignFactory
{
  public ZodiacStarSignFactory()
  {
    super();
  }

  @Override
  protected StarSign createStarSign(String name)
  {
    StarSign zodiacSign = new ZodiacSign(name);
    return zodiacSign;
  }
}
