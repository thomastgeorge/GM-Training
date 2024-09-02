package com.graymatter.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HadlerException {
	
	@ExceptionHandler(InvalidQueryException.class)
	public ResponseEntity<String> handleInvalidQuery(InvalidQueryException iqe) {
		return new ResponseEntity<>("Invalid Query", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<String> handleEventNotFound(ProductIdNotFoundException pnf) {
		return new ResponseEntity<>("No Product Id Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException nse){
		return new ResponseEntity<>("The requested id not exist", HttpStatus.NOT_FOUND);
	}

}
