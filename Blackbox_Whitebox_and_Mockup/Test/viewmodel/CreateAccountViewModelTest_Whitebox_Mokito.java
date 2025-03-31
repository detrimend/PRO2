package viewmodel;

import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
/*
 Dependencies:

 Mockito Core:	mockito-core-5.2.0.jar
   https://mvnrepository.com/artifact/org.mockito/mockito-core/5.2.0
 Mockito Inline:	mockito-inline-5.2.0.jar
 JUnit Jupiter API:	junit-jupiter-api-5.9.2.jar
 JUnit Console Launcher:	junit-platform-console-standalone-1.9.2.jar
 ByteBuddy:	byte-buddy-1.14.3.jar
 ByteBuddy agent: byte-buddy-agent-1.14.3.jar
 Objenesis:	objenesis-3.3.jar
 APIGuardian: API	apiguardian-api-1.1.2.jar

 */

class CreateAccountViewModelTest_Whitebox_Mokito
{
  private CreateAccountViewModel viewModel;
  private UserModel mockModel;

  @BeforeEach void setUp()
  {
    this.mockModel = mock(UserModel.class);
    this.viewModel = new CreateAccountViewModel(mockModel);
  }

  private void initUserPasswordEmail()
  {
    viewModel.getUserProperty().set("sva");
    viewModel.getPasswordProperty().set("Abcdef123");
    viewModel.getEmailProperty().set("sva@simpleemail.dk");
  }

  @Test void createdState()
  {
    assertEquals(null, viewModel.getUserProperty().get());
    assertEquals(null, viewModel.getPasswordProperty().get());
    assertEquals(null, viewModel.getEmailProperty().get());
    assertEquals(null, viewModel.getErrorProperty().get());
  }

  @Test void clear()
  {
    initUserPasswordEmail();
    viewModel.getErrorProperty().set("Some error");

    viewModel.clear();

    assertEquals(null, viewModel.getUserProperty().get());
    assertEquals(null, viewModel.getPasswordProperty().get());
    assertEquals(null, viewModel.getEmailProperty().get());
    assertEquals(null, viewModel.getErrorProperty().get());
  }

  @Test void createUser_Success()
  {
    doNothing().when(mockModel).addUser(anyString(), anyString(), anyString());

    initUserPasswordEmail();

    boolean result = viewModel.createUser();

    assertTrue(result);
    assertEquals(null, viewModel.getErrorProperty().get());
  }

  @Test void createUser_IllegalStateException()
  {
    doThrow(new IllegalStateException("User already exists")).when(mockModel)
        .addUser(anyString(), anyString(), anyString());

    initUserPasswordEmail();

    boolean result = viewModel.createUser();

    assertFalse(result);
    assertEquals("User already exists", viewModel.getErrorProperty().get());
  }

  @Test void createUser_IllegalArgumentException()
  {
    doThrow(new IllegalArgumentException("Illegal argument")).when(mockModel)
        .addUser(anyString(), anyString(), anyString());

    initUserPasswordEmail();

    boolean result = viewModel.createUser();

    assertFalse(result);
    assertEquals("Illegal argument", viewModel.getErrorProperty().get());
  }
}