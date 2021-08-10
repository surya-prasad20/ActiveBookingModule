package com.vrs.exception;

public class ActiveBookingInvalidInputException extends RuntimeException{

	public ActiveBookingInvalidInputException() {
		super();
	}

	public ActiveBookingInvalidInputException(String message) {
		super(message);
	}

	public ActiveBookingInvalidInputException(Throwable cause) {
		super(cause);
	}

	
}
