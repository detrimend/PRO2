package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest
{

  @BeforeEach void setUp()
  {
  }

  @Test void constructorNull()
  {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Password(null));
    assertEquals("Password must have at least 6 characters", e.getMessage());
  }

  @Test void constructor5Characters()
  {
    IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
        () -> new Password("12345"));
    assertEquals("Password must have at least 6 characters", e.getMessage());
  }

  @Test void constructor6Characters()
  {
    assertDoesNotThrow(() -> new Password("ABcd12"));
  }

  @Test void constructor9Characters()
  {
    assertDoesNotThrow(() -> new Password("ABCdef123"));
  }
}