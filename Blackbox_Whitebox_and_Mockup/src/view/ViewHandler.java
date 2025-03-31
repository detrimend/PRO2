package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private CreateAccountViewController createAccountViewController;
  private MessageViewController messageViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("create");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "create":
        root = loadCreateAccountView("CreateAccountView.fxml");
        break;
      case "message":
        root = loadMessageView("MessageView.fxml");
        break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadCreateAccountView(String fxmlFile)
  {
    Region root = null;
    if (createAccountViewController == null)
    {
      // load from FXML
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        createAccountViewController = loader.getController();
        createAccountViewController.init(this, viewModelFactory.getCreateAccountViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      // reset window
      createAccountViewController.reset();
    }
    return createAccountViewController.getRoot();
  }

  private Region loadMessageView(String fxmlFile)
  {
    Region root = null;
    if (messageViewController == null)
    {
      // load from FXML
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        messageViewController = loader.getController();
        messageViewController.init(this, viewModelFactory.getMessageViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      // reset window
      messageViewController.reset();
    }
    return messageViewController.getRoot();
  }

}
