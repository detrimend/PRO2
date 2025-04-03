package mediator;

import model.Model;

import java.io.IOException;
import java.net.ServerSocket;

public class ExercisesServer implements Runnable
{
  private static final int PORT = 2910;
  private boolean running;
  private ServerSocket welcomeSocket;
  private Model model;

  public ExercisesServer(Model model)
  {
    this.model = model;
  }

  public void run()
  {
    running = true;
    try
    {
      welcomeSocket = new ServerSocket(PORT);
      System.out.println("Server started");
      while (running)
      {
        System.out.println("Waiting for a client...");
        ExercisesClientHandler c = new ExercisesClientHandler(welcomeSocket.accept(), model);
        Thread t = new Thread(c);
        t.setDaemon(true);
        t.start();
      }
    }
    catch (Exception e)
    {
      // nothing
    }
  }

  public void close()
  {
    running = false;
    try
    {
      welcomeSocket.close();
    }
    catch (IOException e)
    {
      System.out.println("Server closed");
    }
  }

}
