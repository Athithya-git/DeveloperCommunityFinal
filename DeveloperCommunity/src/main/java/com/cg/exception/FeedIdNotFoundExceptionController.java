package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FeedIdNotFoundExceptionController {
	  @ExceptionHandler(value = FeedIdNotFoundException.class)
	   public ResponseEntity<Object> exception(FeedIdNotFoundException exception) {
	      return new ResponseEntity<>("feed Id not found", HttpStatus.NOT_FOUND);
	   }
}
