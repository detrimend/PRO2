import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class TaskListCommunicationThreadHandler implements Runnable
{
  private DataInputStream in;
  private DataOutputStream out;
  private String ip;
  private TaskList taskList;

  public TaskListCommunicationThreadHandler(Socket socket, TaskList tasks)
  {
    try
    {
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      ip = socket.getInetAddress().getHostAddress();
      taskList = tasks;
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e);
    }
  }

  public void run()
  {
    try
    {
      while (true)
      {
        String request = in.readUTF();
        System.out.println("Client " + ip + "> " + request);

        if ("ADD".equals(request))
        {
          String text = in.readUTF();
          long estimatedTime = in.readLong();
          Task task = new Task(text, estimatedTime);
          taskList.add(task);
          System.out.println("Client " + ip + "> ADD: " + task);
        }
        else if ("GET".equals(request))
        {
          Task task = taskList.getAndRemoveNextTask();
          if (task != null)
          {
            out.writeUTF(task.getText());
            out.writeLong(task.getEstimatedTime());
            System.out.println("Client " + ip + "> GET: " + task);
          }
          else
          {
            out.writeUTF("No tasks");
            System.out.println("Client " + ip + "> ERROR");
          }
        }
        else if ("SIZE".equals(request))
        {
          out.writeInt(taskList.size());
          System.out.println("Client " + ip + "> SIZE: " + taskList.size());
        }
        else
        {
          System.out.println("Client " + ip + "> EXIT");
          break;
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e);
    }
  }
}
