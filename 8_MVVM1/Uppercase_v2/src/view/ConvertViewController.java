package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ConvertViewModel;

public class ConvertViewController
{
  @FXML private TextField requestField;
  @FXML private TextField replyField;
  @FXML private Label errorLabel;
  private Region root;
  private ConvertViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
    requestField.textProperty().bindBidirectional(viewModel.getRequestProperty());
    replyField.textProperty().bind(viewModel.getReplyProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }

  public Region getRoot()
  {
    return root;
  }

  public void reset()
  {
    // Empty
  }

  @FXML private void onSubmit()
  {
    viewModel.convert();
  }

  @FXML private void onEnter()
  {
    onSubmit();
  }
}
