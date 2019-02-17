package com.sauryatech.ratelimiter.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RateLimitController.class)
public class RateLimitControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetUsers() throws Exception
	{
		MockHttpServletResponse response = mockMvc.perform(get("/api/users?apiKey=abc")).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("Request Accepted");
		
		for (int i = 0; i < 101; i++)
		{
			response = mockMvc.perform(get("/api/users?apiKey=abc")).andReturn().getResponse();
		}
		
		// return too many request status when request limit has been reached
		// the request limit is 100 in one hour
		assertThat(response.getStatus()).isEqualTo(HttpStatus.TOO_MANY_REQUESTS.value());
	}
	
	@Test
	public void testGetProducts() throws Exception
	{
		MockHttpServletResponse response = mockMvc.perform(get("/api/products")).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("Request Accepted");
		
		for (int i = 0; i < 101; i++)
		{
			response = mockMvc.perform(get("/api/products")).andReturn().getResponse();
		}
		
		// return too many request status when request limit has been reached
		// the request limit is 100 in one hour
		assertThat(response.getStatus()).isEqualTo(HttpStatus.TOO_MANY_REQUESTS.value());
	}

}
