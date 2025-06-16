public class ZodiacSign extends StarSign
{
  public static final String[] NAMES = {
    "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
    "Libra", "Scorpio", "Sagittarius", "Capricorn", "Aquarius", "Pisces"
  };
  private DateInterval interval;

  public ZodiacSign(String name)
  {
    super(name);
    interval = getInterval();
  }

  public DateInterval getInterval()
  {
    switch (getName())
    {
      case "Aries":
        return new DateInterval(21, 3, 20, 4);
      case "Taurus":
        return new DateInterval(21, 4, 20, 5);
      case "Gemini":
        return new DateInterval(21, 5, 21, 6);
      case "Cancer":
        return new DateInterval(22, 6, 22, 7);
      case "Leo":
        return new DateInterval(23, 7, 22, 8);
      case "Virgo":
        return new DateInterval(23, 8, 22, 9);
      case "Libra":
        return new DateInterval(23, 9, 22, 10);
      case "Scorpio":
        return new DateInterval(23, 10, 21, 11);
      case "Sagittarius":
        return new DateInterval(22, 11, 21, 12);
      case "Capricorn":
        return new DateInterval(22, 12, 20, 1);
      case "Aquarius":
        return new DateInterval(21, 1, 19, 2);
      case "Pisces":
        return new DateInterval(20, 2, 20, 3);
      default:
        throw new IllegalArgumentException("Unknown zodiac sign: " + getName());
    }

  }

  @Override public String getDescription()
  {
    switch (getName())
    {
      case "Aries":
        return "The Ram: Energetic and courageous.";
      case "Taurus":
        return "The Bull: Reliable and patient.";
      case "Gemini":
        return "The Twins: Adaptable and communicative.";
      case "Cancer":
        return "The Crab: Intuitive and emotional.";
      case "Leo":
        return "The Lion: Confident and charismatic.";
      case "Virgo":
        return "The Maiden: Analytical and meticulous.";
      case "Libra":
        return "The Scales: Diplomatic and fair-minded.";
      case "Scorpio":
        return "The Scorpion: Passionate and resourceful.";
      case "Sagittarius":
        return "The Archer: Optimistic and adventurous.";
      case "Capricorn":
        return "The Goat: Disciplined and ambitious.";
      case "Aquarius":
        return "The Water Bearer: Innovative and humanitarian.";
      case "Pisces":
        return "The Fish: Compassionate and artistic.";
      default:
        return "";
    }
  }

  private void setInterval(DateInterval interval)
  {
    this.interval = interval;
  }

  private static String convertName(String name)
  {
    if (name == null || name.isEmpty())
    {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
    return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
  }
}
