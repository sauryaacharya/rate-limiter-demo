# Rate Limiter Demo

This is a Spring Boot project to demonstrate the usage of Rate Limiter module to limit the api request.

## Running the project

- Import rate-limiter-demo and [rate-limiter](https://github.com/sauryaacharya/rate-limiter) project to the eclipse
- Right click on **rate-limiter-demo**, go to **Build Path** and click on **Configure Build Path**
- Go to **Projects** tab and click **Add** and the dialog box appears to select the project
- Select the project **rate-limiter** and click **Ok** and **Apply and Close**
- Right click on the project, go to **Maven** and click **Update Project**
- A dialog box appears, select these two projects and select **Force Update of Snapshots/Releases**

## Now we are ready to run

- Go to **rate-limiter-demo** and run **RateLimiterDemoApplication.java**

## Sending the request to the API

- Use any tool such as Postman or Advance Rest Client to send the API request
  - Sending Request 
  There are two endpoints in this demo
  - http://localhost:8080/api/users?apiKey=abc123
  - http://localhost:8080/api/products
  
  The first endpoint uses apiKey as a key for rate limiting the request
  
  The second endpoint uses ip address as a key for rate limiting the request
