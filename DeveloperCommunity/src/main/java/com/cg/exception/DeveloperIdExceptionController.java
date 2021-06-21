package com.cg.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DeveloperIdExceptionController {
   @ExceptionHandler(value = DeveloperIdNotFoundException.class)
   public ResponseEntity<Object> exception(DeveloperIdNotFoundException exception) {
      return new ResponseEntity<>("Developer Id not found", HttpStatus.NOT_FOUND);
   }
}
