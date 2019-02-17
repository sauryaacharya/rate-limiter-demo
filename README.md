# Rate Limiter Demo

This is a Spring Boot project to demonstrate the usage of Rate Limiter module to limit the api request.

## Running the project

- Import rate-limiter-demo and [rate-limiter](https://github.com/sauryaacharya/rate-limiter) project to the eclipse
- Right click on **rate-limiter-demo**, go to **Build Path** and click on **Configure Build Path**

![Configure Build Path](https://github.com/sauryaacharya/tests/blob/master/buildpath.png)

- Go to **Projects** tab and click **Add** and the dialog box appears to select the project

![Project Selection](https://github.com/sauryaacharya/tests/blob/master/project_selection.png)

- Select the project **rate-limiter** and click **Ok** and **Apply and Close**
- Right click on the project, go to **Maven** and click **Update Project**

![Maven Update](https://github.com/sauryaacharya/tests/blob/master/maven_update.png)

- A dialog box appears, select these two projects and select **Force Update of Snapshots/Releases**

![Update Project](https://github.com/sauryaacharya/tests/blob/master/update_project.png)

## Now we are ready to run

- Go to **rate-limiter-demo** and run **RateLimiterDemoApplication.java**

## Sending the request to the API

- Use any tool such as Postman or Advance Rest Client to send the API request
  ### Sending Request 
  #### There are two endpoints in this demo
  - http://localhost:8080/api/users?apiKey=12ab
  - http://localhost:8080/api/products
  
  ##### The first endpoint uses apiKey as a key for rate limiting the request
  
  This just returns with HTTP Status 200 and Requested Accepted string as a response when it has not reached a limit.
  
  ![API Key Request Accepted](https://github.com/sauryaacharya/tests/blob/master/apiKey_accepted.png)
  
  Once the API limit has been reached, it returns HTTP Status 429 Too Many Request with error message: **Rate Limit Exceeded. Try again in #{n} seconds**
  
  ![API Key Rejected](https://github.com/sauryaacharya/tests/blob/master/apiKey_rejected.png)
  
  ##### The second endpoint uses ip address as a key for rate limiting the request
  
  This just returns with HTTP Status 200 and Requested Accepted string as a response when it has not reached a limit.
  
  ![IP Request Accepted](https://github.com/sauryaacharya/tests/blob/master/ip_accepted.png)
  
  Once the API limit has been reached, it returns HTTP Status 429 Too Many Request with error message: **Rate Limit Exceeded. Try again in #{n} seconds**
  
  ![IP Key Rejected](https://github.com/sauryaacharya/tests/blob/master/ip_rejected.png)
