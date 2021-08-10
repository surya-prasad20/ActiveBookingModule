package com.vrs.exception;

public class ActiveBookingDuplicateValueException extends RuntimeException {

	public ActiveBookingDuplicateValueException() {
		super();
	}

	public ActiveBookingDuplicateValueException(String message) {
		super(message);
	}

	public ActiveBookingDuplicateValueException(Throwable cause) {
		super(cause);
	}
        
}
