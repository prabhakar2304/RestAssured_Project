package DAY_3;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Logging_demo 
{ 
	@Test(priority=1)
	void testLogs()
	{
		given()
		
		.when()
			.get("https://www.google.com")
			
	    .then()
			//.log().all();
	   // .log().body()
		//.log().headers();
		.log().cookies();
	}

}
