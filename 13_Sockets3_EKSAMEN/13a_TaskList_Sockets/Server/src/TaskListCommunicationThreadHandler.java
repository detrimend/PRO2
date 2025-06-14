import com.google.gson.Gson;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TaskListCommunicationThreadHandler
    implements PropertyChangeListener, Runnable
{
  private BufferedReader in;
  private PrintWriter out;
  private String ip;
  private TaskList tasks;
  private Gson gson;

  public TaskListCommunicationThreadHandler(Socket socket, TaskList tasks)
  {
    try
    {
      this.tasks = tasks;
      in = new BufferedReader(
          new java.io.InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      ip = socket.getInetAddress().getHostAddress();
      gson = new Gson();
      tasks.addListener(this);
    }
    catch (Exception e)
    {
      System.err.println(
          "Error initializing TaskListCommunicationThreadHandler: "
              + e.getMessage());
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    System.out.println("Property changed: " + evt.getPropertyName());
    out.println(evt.getPropertyName());
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        String request = in.readLine();
        if (request == null)
        {
          break; // Client disconnected
        }
        System.out.println("Request from " + ip + ": " + request);

        switch (request)
        {
          case "ADD":
            String taskJson = in.readLine(); // Read the task JSON
            Task newTask = gson.fromJson(taskJson, Task.class);
            tasks.add(newTask);
            break;
          case "GET":
            Task nextTask = tasks.getAndRemoveNextTask();
            if (nextTask != null)
            {
              out.println(gson.toJson(nextTask)); // Send the next task as JSON
            }
            else
            {
              out.println("ERROR");
            }
            break;
          case "SIZE":
            String size = String.valueOf(tasks.size());
            out.println(size);
            break;
          default:
            out.println("EXIT");

        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
