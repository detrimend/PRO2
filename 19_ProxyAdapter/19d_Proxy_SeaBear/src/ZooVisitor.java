public class ZooVisitor
{
  private VisitSeaBear seaBear;
  private String personType;

  public ZooVisitor(VisitSeaBear seaBear, String personType)
  {
    this.seaBear = seaBear;
    this.personType = personType;
  }

  public void viewSeaBear()
  {
    seaBear.view(personType);
  }

  public void feedSeaBear()
  {
    seaBear.feed(personType);
  }

  public void petSeaBear()
  {
    seaBear.pet(personType);
  }
}
