package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class ConvertViewModel
{
  private Model model;
  private StringProperty request;
  private StringProperty reply;
  private StringProperty error;

  public ConvertViewModel(Model model)
  {
    this.model = model;
    request = new SimpleStringProperty();
    reply = new SimpleStringProperty();
    error = new SimpleStringProperty();
  }

  public void convert()
  {
    try
    {
      String reply = model.convert(request.get());
      this.reply.set(reply);
      error.set("");
    }
    catch (Exception e)
    {
      error.set(e.getMessage());
    }
  }

  public StringProperty getRequestProperty()
  {
    return request;
  }

  public StringProperty getReplyProperty()
  {
    return reply;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
}
