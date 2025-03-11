import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient
{
  public static void main(String args[])
      throws UnknownHostException, IOException
  {
    int port = 5678;
    String host = "10.154.220.43";

    if (args.length > 0)
    {
      host = args[0];
    }
    if (args.length > 1)
    {
      try
      {
        port = Integer.parseInt(args[1]);
      }
      catch (Exception e)
      {
      }
    }

    // Create keyboard input stream
    Scanner input = new Scanner(System.in);

    // Create client socket, connect to server
    Socket socket = new Socket(host, port);

    // Create input stream attached to the socket
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

    // Create output stream attached to the socket
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

    System.out.print("Write 'connect' to connect: ");

    // Read line from keyboard
    String request = input.nextLine();
    System.out.println("Client> " + request);

    // Send line to server
    out.println(request);

    // Read line from server
    String reply = in.readLine();
    System.out.println("Server> " + reply);

    // Read line from keyboard
    System.out.println("Reply: ");
    request = input.nextLine();
    System.out.println("Client> " + request);

    // Send line to server
    out.println(request);

    // Read line from server
    reply = in.readLine();
    System.out.println("Server> " + reply);

    // Read line from keyboard
    System.out.println("Reply: ");
    request = input.nextLine();
    System.out.println("Client> " + request);

    // Send line to server
    out.println(request);

    // Read line from server
    reply = in.readLine();
    System.out.println("Server> " + reply);

    // Close connection
    socket.close();
  }
}