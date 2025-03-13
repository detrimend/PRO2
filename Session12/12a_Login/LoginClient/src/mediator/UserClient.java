package mediator;

import com.google.gson.Gson;
import model.Model;

import java.io.*;
import java.net.Socket;

public class UserClient implements Model
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private Gson gson;

  public UserClient(String host, int port)
  {
    try
    {
      socket = new Socket(host, port);
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      gson = new Gson();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void login(String userName, String password)
      throws IllegalStateException, IllegalArgumentException
  {
    try
    {
      User user = new User(userName, password);
      String json = gson.toJson(user);
      out.println(json);
      System.out.println("Sent to server: " + json);

      String response = in.readLine();
      if (response.equals("Success, you are now logged in!"))
      {
        System.out.println(response);
      }
      else
      {
        throw new Exception("Error: " + response);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

  }
}
