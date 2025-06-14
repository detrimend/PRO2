import java.io.BufferedReader;

public class TaskListClientReceiver implements Runnable
{
  private TaskListClient client;
  private BufferedReader in;

  TaskListClientReceiver(TaskListClient client, BufferedReader in)
  {
    this.client = client;
    this.in = in;
  }

  @Override public void run()
  {
    while(true)
    {
      try
      {
        String receivedString = in.readLine();
        if (receivedString == null)
        {
          break; // Client disconnected
        }
        System.out.println("Received: " + receivedString);
        client.receive(receivedString);
      }
      catch (Exception e)
      {
        System.err.println("Error receiving data: " + e.getMessage());
        break;
      }
    }
  }
}
