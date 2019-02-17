package com.sauryatech.ratelimiter.demo.exception;

/**
 * 
 * @author sauryadhwojacharya
 * 
 * POJO class for Exception response
 *
 */
public class ExceptionResponse {
	
	private String message;
	
	private int errorCode;
	
	public ExceptionResponse(int errorCode, String message, String details) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}

