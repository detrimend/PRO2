package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.UserModel;

public class MessageViewModel
{
  private UserModel model;
  private StringProperty message;

  public MessageViewModel(UserModel model)
  {
    this.model = model;
    message = new SimpleStringProperty();
  }

  public void update()
  {
    message.set("Number of users: " + model.getUserCount());
  }

  public StringProperty messageProperty()
  {
    return message;
  }
}
