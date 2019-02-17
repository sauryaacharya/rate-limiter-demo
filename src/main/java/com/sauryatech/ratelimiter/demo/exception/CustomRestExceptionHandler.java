package com.sauryatech.ratelimiter.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author sauryadhwojacharya
 * 
 * Custom exception handler class
 *
 */
@ControllerAdvice
@RestController
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TooManyRequestException.class)
	public final ResponseEntity<Object> handleTooManyRequestException(TooManyRequestException ex, WebRequest request) {
		ExceptionResponse response = new ExceptionResponse(HttpStatus.TOO_MANY_REQUESTS.value(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(response, HttpStatus.TOO_MANY_REQUESTS);
	}
}

