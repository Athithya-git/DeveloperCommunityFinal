package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class FeedKeywordNotFoundExceptionController {
	 @ExceptionHandler(value = FeedTopicNotFoundException.class)
	   public ResponseEntity<Object> exception(FeedKeywordNotFoundException exception) {
	      return new ResponseEntity<>("Feed Keyword not found", HttpStatus.NOT_FOUND);
	   }
}
