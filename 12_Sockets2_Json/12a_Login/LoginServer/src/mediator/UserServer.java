package mediator;

import model.Model;

import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable
{
  private static final int PORT = 2910;
  private boolean running;
  private ServerSocket welcomeSocket;
  private Model model;

  public UserServer(Model model)
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
        Socket socket = welcomeSocket.accept();
        System.out.println(
            "Client connected: " + socket.getInetAddress().getHostAddress());
        UserClientHandler c = new UserClientHandler(socket, model);
        Thread t = new Thread(c);
        t.start();
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void close()
  {
    running = false;
  }
}
