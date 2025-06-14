public class Client
{
  public static void main(String[] args)
  {
    String host = "localhost"; // or the server's IP address
    int port = 2910; // The port number the server is listening on

    TaskListClient client = new TaskListClient(host, port);
  }
}
