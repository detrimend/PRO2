import model.*;

import java.util.Scanner;

public class UserClientTest
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    model.login(username, password);
  }
}
