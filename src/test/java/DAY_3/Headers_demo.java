package DAY_3;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Headers_demo 
{
	@Test(priority=1)
	void testHeaders()
	{
		given()
		
		.when()
			.get("https://www.google.com")
			
	    .then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
		    .header("Server", "gws");
		    
	}
	
	@Test(priority=2)   
	void getHeadersInfo()
	{
		Response res=given()
				
		.when()
			.get("https://www.google.com");
		
	    String str=res.getHeader("Content-Type");
	    
	    System.out.println("Value Of Header Content-Type is: "+str);
	}
	
	@Test(priority=3)
	void getAllHeadersInfo()
	{
		Response res=given()
				
		.when()
			.get("https://www.google.com");
		
		Headers  myheaders=res.getHeaders();
		for(Header h:myheaders)
		{
			System.out.println("Key: "+h.getName()+" Value: "+h.getValue());
		}
			
//	    System.out.println("All Headers are: "+res.getHeaders());  //ALL HEADERS
	}
}
