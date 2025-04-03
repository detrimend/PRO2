package mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.google.gson.Gson;
import model.Model;

public class UserClientHandler implements Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private boolean running;
  private Gson gson;
  private String clientIp;
  private Model model;

  public UserClientHandler(Socket socket, Model model) throws IOException
  {
    this.socket = socket;
    this.model = model;
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    clientIp = socket.getInetAddress().getHostAddress();
  }

  public void run()
  {
    gson = new Gson();
    try
    {
      String clientText = in.readLine();
      System.out.println("Client " + clientIp + "> " + clientText);

      UserPackage userPackage = gson.fromJson(clientText, UserPackage.class);
      System.out.println("User: " + userPackage);

      try
      {
        model.addUser(userPackage.getUser(), userPackage.getPassword());
        out.println("Success, you are now logged in!");
      }
      catch (Exception e)
      {
        out.println(e.getMessage());
      }

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public void close() throws IOException
  {
    socket.close();
  }
}
