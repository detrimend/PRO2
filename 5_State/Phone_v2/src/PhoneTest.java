public class PhoneTest
{
  public static void main(String[] args)
  {
    Phone p = new Phone();
    System.out.println("Start up, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.receive("Hello Martin");

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.receive("HELLO MARTIN");

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.receive("bzzz bzzzzzz martin bzzzz");
  }
}
