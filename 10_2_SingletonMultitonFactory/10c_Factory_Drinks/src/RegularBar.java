public class RegularBar extends Bar
{
  private String[] drinkTypes = {
    "Carlsberg", "Tuborg Classic", ""
  };

  @Override protected Drink makeDrink(String name)
  {
    return null;
  }

  @Override public String[] getDrinkTypes()
  {
    return new String[0];
  }
}
