package app.controllers;

import app.exceptions.LoginFailureException;
import app.models.LoginForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  @PostMapping("/login")
  public ResponseEntity postController(
      @RequestBody LoginForm loginForm) throws LoginFailureException {
    System.out.println(loginForm.getUsername());
    System.out.println(loginForm.getPassword());
    if("admin".equals(loginForm.getUsername()) && "admin".equals(loginForm.getPassword())){
      return new ResponseEntity<>(loginForm, HttpStatus.OK);
      //ResponseEntity.ok()
      ///ResponseEntity.status(HttpStatus.OK)
    }
    if("exception".equals(loginForm.getUsername())){
      throw new LoginFailureException("You asked for it");
    }
    return ResponseEntity.status(403).build();
  }
}
