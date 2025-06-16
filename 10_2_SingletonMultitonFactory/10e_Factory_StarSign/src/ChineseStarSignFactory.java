public class ChineseStarSignFactory extends StarSignFactory
{
  public ChineseStarSignFactory()
  {
    super();
  }

  @Override
  protected StarSign createStarSign(String name)
  {
    StarSign chineseSign = new ChineseSign(name);
    return chineseSign;
  }
}
