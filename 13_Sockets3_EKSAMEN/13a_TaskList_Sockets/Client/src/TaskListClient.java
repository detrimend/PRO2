import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class TaskListClient
{
  Socket socket;
  BufferedReader in;
  PrintWriter out;
  Scanner input;
  String receivedString;
  private Gson gson;

  public TaskListClient(String host, int port)
  {
    try
    {
      socket = new Socket(host, port);
      in = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      input = new Scanner(System.in);
      gson = new Gson();
    }
    catch (Exception e)
    {
      System.err.println("Error initializing TaskListClient: " + e.getMessage());
    }
    execute();
  }

  public synchronized void receive(String s)
  {
    if (s.equals("ADD") || s.equals("REMOVE"))
    {
      System.out.println("Server broadcast> " + s);
    }
    else
    {
      receivedString = s;
      notify();
    }
  }

  private synchronized void execute()
  {
    Scanner input = new Scanner(System.in);
    boolean running = true;
    TaskListClientReceiver receiver = new TaskListClientReceiver(this, in);
    Thread receiverThread = new Thread(receiver);
    receiverThread.start();
    while (running)
    {
      System.out.println("\n1) Add a task");
      System.out.println("2) Get a task");
      System.out.println("3) Get task size");
      System.out.println("Any other number) Exit");

      System.out.print("\nEnter choice: ");
      int choice = input.nextInt();
      input.nextLine(); // Consume the newline character
      System.out.println();

      switch (choice)
      {
        case 1:
          out.println("ADD");
          System.out.print("Enter the task: ");
          String taskName = input.nextLine();
          System.out.print("Enter the estimated time: ");
          long estimatedTime = input.nextLong();
          input.nextLine();
          Task task = new Task(taskName, estimatedTime);
          out.println(gson.toJson(task));
          break;
        case 2:
          out.println("GET");
          while (receivedString == null)
          {
            try
            {
              wait(); // Wait for the server to send a task
            }
            catch (InterruptedException e)
            {
              System.err.println("Error waiting for task: " + e.getMessage());
            }
          }
          Task receivedTask = gson.fromJson(receivedString, Task.class);
          System.out.println("Received task: " + receivedTask.toString());
          receivedString = null; // Reset
          break;
        case 3:
          out.println("SIZE");
          while (receivedString == null)
          {
            try
            {
              wait(); // Wait for the server to send the size
            }
            catch (InterruptedException e)
            {
              System.err.println("Error waiting for size: " + e.getMessage());
            }
          }
          int size = Integer.parseInt(receivedString);
          System.out.println("Task list size: " + size);
          receivedString = null; // Reset
          break;
        default:
          out.println("EXIT");
          running = false;
          try
          {
            socket.close();
            in.close();
            out.close();
            input.close();
          }
          catch (Exception e)
          {
            System.err.println("Error closing resources: " + e.getMessage());
          }
          System.out.println("Exiting...");
      }
      try
      {
        sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
    }
  }
}
