public class Server
{
  public static void main(String[] args)
  {
    int port = 2910;

    TaskList tasks = new TaskList();
    TaskListServer server = new TaskListServer(tasks, port);
  }
}
