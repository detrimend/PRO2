import java.io.*;
import java.net.*;

public class TaskListServer
{
  private ServerSocket welcomeSocket;
  private TaskList taskList;

  public TaskListServer(TaskList taskList, int port) throws IOException
  {
    welcomeSocket = new ServerSocket(port);
    this.taskList = taskList;
    execute();
  }

  private void execute()
  {
    System.out.println("Server started, waiting for clients...");
    while (true)
    {
      try
      {
        // Accept a new client connection
        Socket socket = welcomeSocket.accept();
        System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

        // Create and start a new thread to handle the client communication
        TaskListCommunicationThreadHandler handler = new TaskListCommunicationThreadHandler(socket, taskList);
        Thread thread = new Thread(handler);
        thread.start();
      }
      catch (IOException e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}