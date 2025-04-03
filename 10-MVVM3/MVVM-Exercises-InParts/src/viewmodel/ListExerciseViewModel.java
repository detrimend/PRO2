package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class ListExerciseViewModel
{
  private ObservableList<SimpleExerciseViewModel> list;
  private ObjectProperty<SimpleExerciseViewModel> selectedExerciseProperty;
  private StringProperty errorProperty;
  private Model model;
  private ViewState viewState;

  public ListExerciseViewModel(Model model, ViewState viewState)
  {
    this.model = model;
    this.viewState = viewState;
    this.list = FXCollections.observableArrayList();
    this.selectedExerciseProperty = new SimpleObjectProperty<>();
    this.errorProperty = new SimpleStringProperty();
  }

  public void clear()
  {
    errorProperty.set("");
    selectedExerciseProperty.set(null);
  }

  private void loadFromModel()
  {
    list.clear();
    for (Exercise exercise : model.getAllExercises())
    {
      list.add(new SimpleExerciseViewModel(exercise));
    }
  }

  public void addEdit()
  {

  }


}
