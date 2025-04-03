import java.io.*;
import java.net.*;

public class TCPServer
{
  public static void main(String args[]) throws IOException
  {
    final int PORT = 6789;
    System.out.println("Starting Server...");

    // Create welcoming socket at port 6789
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

      // Convert request to uppercase
      String reply = request.toUpperCase();
      System.out.println("Server> " + reply);

      // Send line to client
      out.println(reply);

      // Loop back and wait for another client connection
    }
  }
}