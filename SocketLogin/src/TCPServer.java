import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer
{
  public static void main(String args[]) throws IOException
  {
    final int PORT = 5678;
    System.out.println("Starting Server...");

    // Create welcoming socket at port 5678
    ServerSocket welcomeSocket = new ServerSocket(PORT);

    while (true)
    {
      System.out.println("Waiting for a client...");

      // Wait for contact by client
      Socket socket = welcomeSocket.accept();

      // Create input stream attached to the socket
      BufferedReader in = new BufferedReader(
          new InputStreamReader(socket.getInputStream()));

      // Create output stream attached to the socket
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

      // Read line from client
      String request = in.readLine();
      System.out.println("Client> " + request);

      if (!"connect".equals(request))
      {
        String reply = "Disconnected";
        System.out.println("Server> " + reply);
        out.println(reply);
        socket.close();
        continue;
      }

      // Send "Username?" to client
      String reply = "Username?";
      System.out.println("Server> " + reply);
      out.println(reply);

      // Read username from client
      String username = in.readLine();
      System.out.println("Client> " + username);

      // Send "Password?" to client
      reply = "Password?";
      System.out.println("Server> " + reply);
      out.println(reply);

      // Read password from client
      String password = in.readLine();
      System.out.println("Client> " + password);

      // Send "Approved" to client
      reply = "Approved";
      System.out.println("Server> " + reply);
      out.println(reply);

      // Close connection with the client
      socket.close();
    }
  }
}