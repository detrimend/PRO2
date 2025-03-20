import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;
import mediator.*;

public class MyApplication extends Application
{
  private ExercisesServer server;

  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);

    server = new ExercisesServer(model);
    Thread t = new Thread(server);
    t.start();

    view.start(primaryStage);
  }

  @Override public void stop()
  {
    server.close();
    System.out.println("Server closed");
  }
}
