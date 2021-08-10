package com.vrs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vrs.entities.ActiveBookingErrorResponse;


@ControllerAdvice
public class ActiveBookingHandler {

	@ExceptionHandler
	public ResponseEntity<ActiveBookingErrorResponse> handleException(ActiveBookingNotFoundException exception)
	{
		ActiveBookingErrorResponse error=new ActiveBookingErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
       
	@ExceptionHandler
	public ResponseEntity<ActiveBookingErrorResponse> handleException(ActiveBookingDuplicateValueException exception)
	{
		ActiveBookingErrorResponse error=new ActiveBookingErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler
	public ResponseEntity<ActiveBookingErrorResponse> handleException(ActiveBookingInvalidInputException exception)
	{
		ActiveBookingErrorResponse error=new ActiveBookingErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
	}

}