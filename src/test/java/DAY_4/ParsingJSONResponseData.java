package DAY_4;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class ParsingJSONResponseData 
{   @Test(priority=1)
	void testJSONResponse()
	{
	
	  given()
	        .contentType("Content-Type.JSON")
	       
	 .when()
	        .get("http://localhost:3000/students")
	        
	 .then()
	        .statusCode(200)
	        .header("Content-Type", "application/json")
	        .body("[10].name", equalTo("rajesh"));
	}
	

}
