public class NotificationTest
{
  public static void main(String[] args)
  {
    Notification notification = new Notification();

    Thread thread = new Thread(notification);

    thread.start();
  }
}
