package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.CreateAccountViewModel;

public class CreateAccountViewController
{
  @FXML private TextField userField;
  @FXML private TextField passwordField;
  @FXML private TextField emailField;
  @FXML private Label errorLabel;

  private Region root;
  private CreateAccountViewModel viewModel;
  private ViewHandler viewHandler;

  public CreateAccountViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewHandler, CreateAccountViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
    userField.textProperty().bindBidirectional(viewModel.getUserProperty());
    passwordField.textProperty()
        .bindBidirectional(viewModel.getPasswordProperty());
    emailField.textProperty().bindBidirectional(viewModel.getEmailProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }

  public void reset()
  {
    viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void createButtonPressed()
  {
    boolean created = viewModel.createUser();
    if (created)
    {
      viewHandler.openView("message");
    }
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.closeView();
  }

  public void onEnter(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == userField)
    {
      passwordField.requestFocus();
    }
    else if (actionEvent.getSource() == passwordField)
    {
      emailField.requestFocus();
    }
    else
    {
      createButtonPressed();
    }
  }
}
