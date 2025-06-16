public class SeaBearGuard implements VisitSeaBear
{
  private VisitSeaBear seaBear;

  public SeaBearGuard(VisitSeaBear seaBear)
  {
    this.seaBear = seaBear;
  }

  @Override
  public void view(String personType)
  {
    seaBear.view(personType);
  }

  @Override
  public void feed(String personType)
  {
    if (personType.equals("zookeeper"))
    {
      seaBear.feed(personType);
    }
    else
    {
      System.out.println("Access denied for " + personType + ". Only zookeepers can feed the Sea Bear.");
    }
  }

  @Override
  public void pet(String personType)
  {
    if (personType.equals("child"))
    {
      seaBear.pet(personType);
    }
    else
    {
      System.out.println("Access denied for " + personType + ". Only children can pet the Sea Bear.");
    }
  }

}
