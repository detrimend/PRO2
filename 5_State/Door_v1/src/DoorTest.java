public class DoorTest
{
  public static void main(String[] args)
  {
    Door d = new Door();
    System.out.println("Start up, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.complete();
    System.out.println("Completed, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.complete();
    System.out.println("Completed, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.complete();
    System.out.println("Completed, the door is " + d.status());

    d.click();
    System.out.println("Clicked, the door is " + d.status());

    d.complete();
    System.out.println("Completed, the door is " + d.status());

    d.timeout();
    System.out.println("Timeout, the door is " + d.status());

    d.complete();
    System.out.println("Completed, the door is " + d.status());


  }
}
