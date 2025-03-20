package mediator;

import com.google.gson.Gson;
import model.Exercise;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ExercisesClientHandler implements PropertyChangeListener, Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private boolean running;
  private Gson gson;
  private Model model;

  public ExercisesClientHandler(Socket socket, Model model) throws IOException
  {
    this.socket = socket;
    this.model = model;
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintWriter(socket.getOutputStream(), true);
    gson = new Gson();
    model.addListener(this);
  }

  public void close() throws IOException
  {
    running = false;
    socket.close();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    ExercisePackage exercisePackage = new ExercisePackage(evt.getPropertyName(),
        (Exercise) evt.getNewValue(), (String) evt.getOldValue());
    out.println(gson.toJson(exercisePackage));
  }

  @Override public void run()
  {
    running = true;
    try
    {
      while (running)
      {
        String request = in.readLine();
        System.out.println("Request: " + request);
        if (request == null)
        {
          break;
        }
        ExercisePackage exercisePackage = gson.fromJson(request,
            ExercisePackage.class);
        switch (exercisePackage.getType())
        {
          case "All":
            ExerciseListPackage listPackage = new ExerciseListPackage("Get",
                model.getAllExercises());
            out.println(gson.toJson(listPackage));
            break;
          case "Get":
            if (model.getExercise(exercisePackage.getNumber()) == null)
            {
              ExercisePackage errorPackage = new ExercisePackage("Error",
                  "Exercise not found");
              out.println(gson.toJson(errorPackage));
              break;
            }
            ExercisePackage getPackage = new ExercisePackage("Get",
                model.getExercise(exercisePackage.getNumber()),
                exercisePackage.getNumber());
            out.println(gson.toJson(getPackage));
            break;
          case "Add":
            try
            {
              model.addExercise(exercisePackage.getExercise());
            }
            catch (Exception e)
            {
              ExercisePackage errorPackage = new ExercisePackage("Error",
                  e.getMessage());
              out.println(gson.toJson(errorPackage));
            }
            break;
          case "Remove":
            try
            {
              // Skal sende error hvis null returneres
              if (model.removeExercise(exercisePackage.getNumber()) == null)
              {
                ExercisePackage errorPackage = new ExercisePackage("Error",
                    "Exercise not found");
                out.println(gson.toJson(errorPackage));
                break;
              }
            }
            catch (Exception e)
            {
              ExercisePackage errorPackage = new ExercisePackage("Error",
                  e.getMessage());
              out.println(gson.toJson(errorPackage));
            }
            break;
          case "Edit":
            try
            {
              model.editExercise(exercisePackage.getNumber(),
                  exercisePackage.getExercise());
            }
            catch (Exception e)
            {
              ExercisePackage errorPackage = new ExercisePackage("Error",
                  e.getMessage());
              out.println(gson.toJson(errorPackage));
            }
            break;
        }
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
