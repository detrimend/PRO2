package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import viewmodel.CreateAccountViewModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.testfx.api.FxAssert.verifyThat;

/*
Dependencies:

TestFX Core (4.0.16-alpha): testfx-core-4.0.16-alpha.jar
 https://mvnrepository.com/artifact/org.testfx/testfx-core/4.0.16-alpha

TestFX JUnit5 (4.0.16-alpha): testfx-junit5-4.0.16-alpha.jar
 https://mvnrepository.com/artifact/org.testfx/testfx-junit5/4.0.16-alpha

JUnit Jupiter API (5.9.2): junit-jupiter-api.jar
 https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2

JUnit Jupiter Engine (5.9.2): junit-jupiter-engine.jar
 https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.9.2

Mockito Core (5.2.0): mockito-core.jar
 https://mvnrepository.com/artifact/org.mockito/mockito-core/5.2.0

 VM settings:
 --add-opens javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
 --add-opens javafx.graphics/javafx.stage=ALL-UNNAMED
 --add-opens javafx.graphics/com.sun.javafx.tk.quantum=ALL-UNNAMED
 */
public class CreateAccountViewControllerTest_Whitebox_TestFX extends ApplicationTest
{
  private CreateAccountViewModel viewModel;
  private UserModel mockModel;
  private ViewHandler mockViewHandler;

  @Override public void start(Stage stage) throws Exception
  {
    mockModel = mock(UserModel.class); // Mock model
    mockViewHandler = mock(ViewHandler.class); // Mock ViewHandler
    viewModel = new CreateAccountViewModel(mockModel);

    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/view/CreateAccountView.fxml"));
    Region root = loader.load();

    CreateAccountViewController controller = loader.getController();
    controller.init(mockViewHandler, viewModel, root);

    stage.setScene(new Scene(root));
    stage.show();
  }

  @BeforeEach void setupEach()
  {
    viewModel.clear();
  }

  @Test void testStateAfterReset()
  {
    // Test ViewModel properties
    assertEquals(null, viewModel.getUserProperty().get());
    assertEquals(null, viewModel.getPasswordProperty().get());
    assertEquals(null, viewModel.getEmailProperty().get());
    assertEquals(null, viewModel.getErrorProperty().get());

    // Test GUI components
    verifyThat("#userField", (TextField field) -> field.getText() == null);
    verifyThat("#passwordField", (TextField field) -> field.getText() == null);
    verifyThat("#emailField", (TextField field) -> field.getText() == null);
    verifyThat("#errorLabel", (Label label) -> label.getText() == null);
  }

  @Test void testUserCanFillFieldsAndCreateAccount()
  {
    // Simulate user input
    clickOn("#userField").write("Bob");
    clickOn("#passwordField").write("BobBuilder123");
    clickOn("#emailField").write("bob@builder.com");

    // Press the button
    clickOn("Create");

    // Test binding: ViewModel received values
    assertEquals("Bob", viewModel.getUserProperty().get());
    assertEquals("BobBuilder123", viewModel.getPasswordProperty().get());
    assertEquals("bob@builder.com", viewModel.getEmailProperty().get());
    assertEquals(null, viewModel.getErrorProperty().get());

    // Test that model.addUser(...) has been correctly called
    verify(mockModel).addUser("Bob", "BobBuilder123", "bob@builder.com");

    // Test that ID in viewHandler.openview(ID) represent the view to open
    verify(mockViewHandler).openView("message");
  }

  @Test void testIllegalInput()
  {
    // Model response
    doThrow(new IllegalArgumentException(
        "Password must have at least 6 characters")).when(mockModel)
        .addUser(anyString(), anyString(), anyString());

    // Simulate user input
    clickOn("#userField").write("Bob");
    clickOn("#passwordField").write("Bob");
    clickOn("#emailField").write("bob@builder.com");

    // Press the button
    clickOn("Create");

    try
    {
      Thread.sleep(5000); // inspect visually the error label
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }

    // Test binding: ViewModel received values
    assertEquals("Bob", viewModel.getUserProperty().get());
    assertEquals("Bob", viewModel.getPasswordProperty().get());
    assertEquals("bob@builder.com", viewModel.getEmailProperty().get());
    assertEquals("Password must have at least 6 characters",
        viewModel.getErrorProperty().get());

    // Test that model.addUser(...) has been correctly called
    verify(mockModel).addUser("Bob", "Bob", "bob@builder.com");

    // Test that error property has been set
    assertEquals("Password must have at least 6 characters",
        viewModel.getErrorProperty().get());

    // Test that errorLabel has been set
    verifyThat("#errorLabel", (Label label) -> label.getText()
        .equals("Password must have at least 6 characters"));

  }

  @Test void testCancelDoesNotTriggerModel()
  {
    clickOn("#userField").write("TestingTheCancelButton");
    clickOn("#passwordField").write("SomePassword");
    clickOn("#emailField").write("let@it.run");

    clickOn("Cancel");

    // Verify no model interaction
    verifyNoInteractions(mockModel);

    // Verify close view
    verify(mockViewHandler).closeView();
  }
}
