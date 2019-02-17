package com.sauryatech.ratelimiter.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sauryatech.ratelimiter.RateLimiter;
import com.sauryatech.ratelimiter.demo.exception.TooManyRequestException;

/**
 * 
 * @author sauryadhwojacharya
 * 
 * This is the simple demo api controller class that is utilising
 * RateLimiter module to limit the api request. The RateLimiter module
 * is a separate java module which can be utilised anywhere such as
 * implementing it in interceptor, filter or in a direct request mapping
 * of an api. This is just to demonstrate with a simple api about the
 * usage of RateLimiter module
 *
 */
@RestController
@RequestMapping("api")
public class RateLimitController {

	private static final int REQUEST_LIMIT = 100;

	// one hour = 3600s
	private static final int INTERVAL = 3600;

	/**
	 * This is just a simple api mapping demo with a get request where apiKey is
	 * used as a key to distinguish the limit the api request for specified api key
	 * 
	 * @param apiKey
	 * @return
	 */
	@GetMapping("users")
	public ResponseEntity<String> getUsers(@RequestParam(value = "apiKey") String apiKey) {
		RateLimiter rateLimiter = RateLimiter.create(apiKey, REQUEST_LIMIT, INTERVAL);
		rateLimiter.fill(apiKey);
		if (rateLimiter.getRequestBucket(apiKey).getIsOverflow()) {
			throw new TooManyRequestException(
					"Rate limit exceeded. Try again in " + rateLimiter.getWaitingTime(apiKey) + " seconds");
		}
		return new ResponseEntity<String>("Request Accepted", HttpStatus.OK);
	}

	/**
	 * This is just a simple api mapping demo with a get request where ip address is
	 * used as a key to distinguish the limit the api request for specified ip address
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("products")
	public ResponseEntity<String> getProducts(HttpServletRequest request) {
		String ipAddress = request.getRemoteAddr();
		RateLimiter rateLimiter = RateLimiter.create(ipAddress, REQUEST_LIMIT, INTERVAL);
		rateLimiter.fill(ipAddress);
		if (rateLimiter.getRequestBucket(ipAddress).getIsOverflow()) {
			throw new TooManyRequestException(
					"Rate limit exceeded. Try again in " + rateLimiter.getWaitingTime(ipAddress) + " seconds");
		}
		return new ResponseEntity<String>("Request Accepted", HttpStatus.OK);
	}
}
