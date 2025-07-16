package org.example.Exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException (Exception e)
  {
      e.printStackTrace();
      return  new ResponseEntity<>("Something wrong", HttpStatusCode.valueOf(500));
  }




}
