package DAY_3;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Cookies_demo {
	
	//String apiKey = "pub_07208d8e904ad1680b8dbbb124acb8f8380f227734d5220928bc06b974bc683e";
	
	@Test(priority=1)
	void testCookies()
	{
		given()
		//.header("x-api-key", apiKey)
		
		.when()
		.get("https://www.google.com")
		
		.then()
	    .cookie("AEC")
		.log().all();

    }
	@Test(priority=2)
	void getsingleCookiesinfo()
	{
		
		Response res=given()
		
		.when()
		.get("https://www.google.com");
		
		String string=res.getCookie("AEC");
	    System.out.println("Value Of Cookie AEC is: "+string);
		
	}
	@Test(priority=3)
	void getAllCookiesinfo()
	{
		
		Response res=given()
		
		.when()
		.get("https://www.google.com");
		
		Map<String, String> cookies=res.getCookies();
		System.out.println(cookies.keySet());  //ALL COOKIES KEYS
		
		for(String key:cookies.keySet())
		{
			System.out.println("Key: "+key+" Value: "+cookies.get(key));
		//System.out.println("All Cookies are: "+res.getCookies());    //ALL COOKIES
		}
	}
	
}
