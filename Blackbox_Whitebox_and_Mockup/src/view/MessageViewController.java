package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import viewmodel.MessageViewModel;

public class MessageViewController
{
  @FXML private Label textLabel;

  private Region root;
  private MessageViewModel viewModel;
  private ViewHandler viewManager;

  public MessageViewController()
  {
    // Called by FXMLLoader
  }

  public void init(ViewHandler viewManager, MessageViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewManager = viewManager;
    this.root = root;
    textLabel.textProperty().bind(viewModel.messageProperty());
    reset();
  }

  public void reset()
  {
    viewModel.update();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML private void okButtonPressed()
  {
    viewManager.closeView();
  }

  @FXML private void createAccountButtonPressed()
  {
    viewManager.openView("create");
  }
}
