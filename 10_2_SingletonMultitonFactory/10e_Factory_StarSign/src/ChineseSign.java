public class ChineseSign extends StarSign
{
  private int year;
  public static final String[] NAMES = {
    "Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake",
    "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"
  };

  public ChineseSign(int year)
  {
    super(NAMES[(year - 4) % 12]);
    this.year = year;
  }

  public ChineseSign(String name)
  {
    super(name);
    this.year = 4 + java.util.Arrays.asList(NAMES).indexOf(name);
    if (this.year < 4) {
      throw new IllegalArgumentException("Invalid year for Chinese sign: " + name);
    }
  }

  public String getYears(int count, int fromYear)
  {
    StringBuilder years = new StringBuilder();
    for (int i = 0; i < count; i++)
    {
      years.append(fromYear + i * 12);
      if (i < count - 1)
      {
        years.append(", ");
      }
    }
    return years.toString();
  }

  @Override public String getDescription()
  {
    switch (getName())
    {
      case "Rat":
        return "Clever and resourceful.";
      case "Ox":
        return "Diligent and dependable.";
      case "Tiger":
        return "Brave and competitive.";
      case "Rabbit":
        return "Gentle and compassionate.";
      case "Dragon":
        return "Confident and charismatic.";
      case "Snake":
        return "Wise and enigmatic.";
      case "Horse":
        return "Energetic and free-spirited.";
      case "Goat":
        return "Creative and kind-hearted.";
      case "Monkey":
        return "Intelligent and playful.";
      case "Rooster":
        return "Observant and hardworking.";
      case "Dog":
        return "Loyal and honest.";
      case "Pig":
        return "Generous and optimistic.";
      default:
        throw new IllegalArgumentException("Unknown Chinese sign: " + getName());
    }
  }

  private static String getName(int year)
  {
    return NAMES[(year - 4) % 12];
  }
}
