package com.cg.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	private String message;

	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [message=" + message + "]";
	}
	
	

}
