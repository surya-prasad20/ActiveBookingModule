package com.vrs.entities;

public class ActiveBookingErrorResponse {

	//fields
	private int status;
	private String message;
	private long timeStamp;
	
	//getters and setters
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	//toString
	@Override
	public String toString() {
		return "ActiveBookingErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	
	
}
