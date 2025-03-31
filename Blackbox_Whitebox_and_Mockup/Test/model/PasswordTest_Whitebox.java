package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest_Whitebox
{
  // Testing the Constructor:

  @Test void constructor_nullPassword()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password(null));
    assertEquals("Password must have at least 6 characters",
        exception.getMessage());
  }

  @Test void constructor_tooShort()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("12345"));
    assertEquals("Password must have at least 6 characters",
        exception.getMessage());
  }

  @Test void constructor_Length6()
  {
    assertDoesNotThrow(() -> new Password("ABcd12"));
  }

  @Test void constructor_length9()
  {
    assertDoesNotThrow(() -> new Password("ABCdef123"));
  }

  @Test void constructor_noUpperCaseLetter()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("abc123"));
    assertEquals("Password must contain at least one uppercase letter, at least one lowercase letter and at least one digit",
        exception.getMessage());
  }

  @Test void constructor_noLowerCaseLetter()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("ABC123"));
    assertEquals("Password must contain at least one uppercase letter, at least one lowercase letter and at least one digit",
        exception.getMessage());
  }

  @Test void constructor_noDigit()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("ABCdef"));
    assertEquals("Password must contain at least one uppercase letter, at least one lowercase letter and at least one digit",
        exception.getMessage());
  }

  @Test void constructor_underscore()
  {
    assertDoesNotThrow(() -> new Password("Ab_cd1234"));
  }

  @Test void constructor_hyphen()
  {
    assertDoesNotThrow(() -> new Password("Ab-cd1234"));
  }

  @Test void constructor_hyphenAndUnderscore()
  {
    assertDoesNotThrow(() -> new Password("Ab_cd-123"));
  }

  @Test void constructor_specialCharacters()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("ABcd12$"));
    assertEquals("Password may only contain letters, digits, hyphens and underscore characters",
        exception.getMessage());
  }

  @Test void constructor_onlySpecialCharacters()
  {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class, () -> new Password("@£$€&(+"));
    assertEquals("Password may only contain letters, digits, hyphens and underscore characters",
        exception.getMessage());
  }

}