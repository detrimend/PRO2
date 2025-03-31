package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.UserModel;

public class CreateAccountViewModel
{
  private UserModel model;
  private StringProperty user;
  private StringProperty password;
  private StringProperty email;
  private StringProperty error;

  public CreateAccountViewModel(UserModel model)
  {
    this.model = model;
    this.user = new SimpleStringProperty();
    this.password = new SimpleStringProperty();
    this.email = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
  }

  public void clear()
  {
    user.set(null);
    password.set(null);
    email.set(null);
    error.set(null);
  }

  public boolean createUser()
  {
    try
    {
      model.addUser(user.get(), password.get(), email.get());
      return true;
    }
    catch (Exception e)
    {
      error.set(e.getMessage());
      return false;
    }
  }

  public StringProperty getUserProperty()
  {
    return user;
  }

  public StringProperty getPasswordProperty()
  {
    return password;
  }

  public StringProperty getEmailProperty()
  {
    return email;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
}
