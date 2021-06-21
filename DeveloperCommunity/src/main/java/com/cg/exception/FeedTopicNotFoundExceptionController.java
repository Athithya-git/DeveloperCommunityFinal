package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FeedTopicNotFoundExceptionController {
	 @ExceptionHandler(value = FeedTopicNotFoundException.class)
	   public ResponseEntity<Object> exception(FeedTopicNotFoundException exception) {
	      return new ResponseEntity<>("Feed topic not found", HttpStatus.NOT_FOUND);
	   }
}
