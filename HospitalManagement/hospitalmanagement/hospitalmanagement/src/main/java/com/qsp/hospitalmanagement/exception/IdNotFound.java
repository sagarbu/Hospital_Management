package com.qsp.hospitalmanagement.exception;

public class IdNotFound extends RuntimeException{
	
	String message;

	public IdNotFound(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
