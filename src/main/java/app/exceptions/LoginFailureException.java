package app.exceptions;

public class LoginFailureException extends Exception {

  public LoginFailureException(final String message) {
    super(message);
  }
}
