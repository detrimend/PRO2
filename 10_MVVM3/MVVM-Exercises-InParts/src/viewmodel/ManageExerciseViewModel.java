package viewmodel;

import javafx.beans.property.*;
import model.*;

public class ManageExerciseViewModel
{
  private StringProperty errorProperty;
  private StringProperty headerProperty;
  private ObjectProperty<Boolean> completedProperty;
  private StringProperty topicProperty;
  private IntegerProperty numberProperty;
  private IntegerProperty sessionProperty;
  private ObjectProperty<Boolean> editableProperty;
  private ViewState viewState;
  private Model model;

  public ManageExerciseViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    this.errorProperty = new SimpleStringProperty();
    this.headerProperty = new SimpleStringProperty();
    this.completedProperty = new SimpleObjectProperty<Boolean>();
    this.topicProperty = new SimpleStringProperty();
    this.numberProperty = new SimpleIntegerProperty();
    this.sessionProperty = new SimpleIntegerProperty();
    this.editableProperty = new SimpleObjectProperty<Boolean>();
  }

  public void reset()
  {
    errorProperty.set("");
    headerProperty.set("Add Exercise");
    completedProperty.set(false);
    topicProperty.set("");
    numberProperty.set(0);
    sessionProperty.set(0);
    editableProperty.set(true);
  }

  public StringProperty getErrorProperty()
  {
    return errorProperty;
  }

  public StringProperty getHeaderProperty()
  {
    return headerProperty;
  }

  public ObjectProperty<Boolean> getCompletedProperty()
  {
    return completedProperty;
  }

  public StringProperty getTopicProperty()
  {
    return topicProperty;
  }

  public IntegerProperty getNumberProperty()
  {
    return numberProperty;
  }

  public IntegerProperty getSessionProperty()
  {
    return sessionProperty;
  }

  public ObjectProperty<Boolean> getEditableProperty()
  {
    return editableProperty;
  }

  private Exercise createExerciseObject()
  {
    return new Exercise(sessionProperty.get(), numberProperty.get(), topicProperty.get());
  }

  public boolean accept()
  {
    try
    {
      if (viewState.isRemove())
      {
        model.removeExercise(viewState.getNumber());
      }
      else
      {
        if (viewState.getNumber().equals(""))
        {
          model.addExercise(createExerciseObject());
        }
        else
        {
          model.editExercise(viewState.getNumber(), createExerciseObject());
        }
      }
      return true;
    }
    catch (Exception e)
    {
      errorProperty.set(e.getMessage());
      return false;
    }
  }



}
