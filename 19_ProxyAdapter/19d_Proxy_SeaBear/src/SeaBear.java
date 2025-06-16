public class SeaBear implements VisitSeaBear
{

  @Override public void view(String personType)
  {
    System.out.println(personType + " is viewing the Sea Bear.");
  }

  @Override public void feed(String personType)
  {
    System.out.println("A " + personType + " is feeding the Sea Bear.");
  }

  @Override public void pet(String personType)
  {
    System.out.println("A " + personType + " is petting the Sea Bear.");
  }
}
