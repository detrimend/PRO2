import java.net.ServerSocket;

public class TaskListServer
{
  private ServerSocket welcomeSocket;
  private TaskList tasks;

  public TaskListServer(TaskList tasks, int port)
  {
    try
    {
      welcomeSocket = new ServerSocket(port);
      this.tasks = tasks;
      System.out.println("TaskListServer started on port " + port);
    }
    catch (Exception e)
    {
      System.err.println("Error starting TaskListServer: " + e.getMessage());
    }
    execute();
  }

  private void execute()
  {
    try
    {
      while (true)
      {
        System.out.println("Waiting for a client...");
        TaskListCommunicationThreadHandler handler = new TaskListCommunicationThreadHandler(
            welcomeSocket.accept(), tasks);
        Thread thread = new Thread(handler);
        thread.setDaemon(true);
        thread.start();
      }
    }
    catch (Exception e)
    {
      System.err.println("Error in TaskListServer: " + e.getMessage());
    }
  }
}
