package com.text.app.flightticketBooking.exceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandleAllException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handlingException(RuntimeException exp){
		return new ResponseEntity<Object>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
