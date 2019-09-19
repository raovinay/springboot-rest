package app.handlers;

import app.exceptions.LoginFailureException;
import javax.security.auth.login.LoginException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlers {
  @ExceptionHandler({LoginFailureException.class})
  public ResponseEntity<String> handleLoginFailure(LoginException e) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
  }
}
