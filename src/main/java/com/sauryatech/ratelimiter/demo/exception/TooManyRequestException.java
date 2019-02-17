package com.sauryatech.ratelimiter.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class TooManyRequestException extends RuntimeException {

	public TooManyRequestException(String message) {
		super(message);
	}

}
