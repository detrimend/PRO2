import mediator.UserServer;
import model.Model;
import model.ModelManager;

public class UserServerTest
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();
    Thread t = new Thread(new UserServer(model));
    t.start();
  }
}
