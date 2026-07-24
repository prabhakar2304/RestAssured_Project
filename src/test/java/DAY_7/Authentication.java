package DAY_7;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.*;

public class Authentication 
{
	@Test(priority=1)
	void testBasicAuthentication()
	{
		
		given()
			.auth().basic("postman", "password")
			
			.when()
				.get("https://postman-echo.com/basic-auth")
	        .then()
	        .statusCode(200)
	        .body("authenticated", equalTo(true))
	        .log().all();
	        
	}
	@Test(priority=2)
	void testDigestAuthentication()
	{
		
		given()
			.auth().digest("postman", "password")
		
			.when()
				.get("https://postman-echo.com/digest-auth")
				
	        .then()
	        .statusCode(200)
	        .body("authenticated", equalTo(true))
	        .log().all();
	}
	@Test(priority=3)
	void testPreemptiveAuthentication()
	{
		
		given()
			.auth().preemptive().basic("postman", "password")
			
			.when()
				.get("https://postman-echo.com/basic-auth")
				
	        .then()
	        .statusCode(200)
	        .body("authenticated", equalTo(true))
	        .log().all();
     }
	//@Test(priority=4)
    void testBearerTokenAuthentication()
	{
		String token="ghp_1a2b3c4d5e6f7g8h9i0jklmnopqrstuvwx";
		given()
			.header("Authorization", "Bearer " + token)
         .when()
		 	.get("https://api.github.com/user/repos")

		 .then()
		 	.statusCode(200)
		 	.log().all();								
	}
    @Test(priority=5)
    void testOAuth1Authentication()
    {
    	given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokensecret")
			
			.when()
				.get("https://api.twitter.com/1.1/statuses/home_timeline.json")
				
	        .then()
	        .statusCode(200)
	        .log().all();	
    }
    @Test(priority=6)
    void testOAuth2Authentication()
    {
    	given()
    				.auth().oauth2("accessToken")
    		.when()
    		.get("https://api.github.com/user/repos")
    				
    		.then()
    		.statusCode(200)
			.log().all();    				
    }
  
}
