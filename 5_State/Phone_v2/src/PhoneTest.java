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

    p.receive("Hello");

    p.volumeUp();
    System.out.println("Volume up, the phone is in " + p.status());

    p.receive("Hello again");

    p.volumeDown();
    System.out.println("Volume down, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.clickSoundButton();
    System.out.println("Clicked, the phone is in " + p.status());

    p.receive("bzzz bzzzzzz martin bzzzz");
  }
}
