import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TaskListClient
{
  private Socket socket;
  private DataInputStream in;
  private DataOutputStream out;
  private Scanner input;

  public TaskListClient(String host, int port)
  {
    try
    {
      socket = new Socket(host, port);
      in = new DataInputStream(socket.getInputStream());
      out = new DataOutputStream(socket.getOutputStream());
      input = new Scanner(System.in);
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e);
    }
    execute();
  }

  private void execute()
  {
    try
    {
      while (true)
      {
        System.out.println("Enter ADD, GET, SIZE, or EXIT:");
        String request = input.nextLine();
        out.writeUTF(request);

        if ("ADD".equals(request))
        {
          System.out.println("Enter task text:");
          String text = input.nextLine();
          out.writeUTF(text);

          System.out.println("Enter estimated time:");
          long estimatedTime = input.nextLong();
          input.nextLine();
          out.writeLong(estimatedTime);
        }
        else if ("GET".equals(request))
        {
          String text = in.readUTF();
          long estimatedTime = in.readLong();
          System.out.println("Task: " + text + " (" + estimatedTime + " ms)");
        }
        else if ("SIZE".equals(request))
        {
          int size = in.readInt();
          System.out.println("Size: " + size);
        }
        else if ("EXIT".equals(request))
        {
          break;
        }
      }
    }
    catch (Exception e)
    {
      System.out.println("Error: " + e);
    }
    finally
    {
      try
      {
        if (socket != null)
        this.socket.close();
      }
      catch (IOException e)
      {
        System.out.println("Error: " + e);
      }
    }
  }
}
