public class Main
{
  public static void main(String[] args)
  {
    // Create a ZodiacStarSignFactory instance
    StarSignFactory zodiacFactory = new ZodiacStarSignFactory();

    // Create a ChineseStarSignFactory instance
    StarSignFactory chineseFactory = new ChineseStarSignFactory();

    // Get a Zodiac star sign
    StarSign zodiacSign = zodiacFactory.getStarSign("Aries");
    System.out.println(zodiacSign);

    // Get a Chinese star sign
    StarSign chineseSign = chineseFactory.getStarSign("Rat");
    System.out.println(chineseSign);
  }
}
