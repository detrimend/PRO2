public class Client
{
  public static void main(String args[])
  {
    final String HOST = "localhost";
    final int PORT = 5678;
    System.out.println("Starting Client...");

    TaskListClient client = new TaskListClient(HOST, PORT);
  }
}
