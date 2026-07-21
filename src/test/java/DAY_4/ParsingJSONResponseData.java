package DAY_4;

import static io.restassured.RestAssured.*;


import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import org.json.JSONArray;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
	        .body("[0].name", equalTo("arun"));
	}
    //Approach 2
	@Test(priority=2)
	void testJSONResponse2()
	{
	Response response=given()
			           .contentType("Content-Type.JSON")
			.when()
			           .get("http://localhost:3000/students");
	     
	         Assert.assertEquals(response.getStatusCode(), 200);
	         Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
	         String nameString= response.jsonPath().get("[0].name").toString();
	         Assert.assertEquals(nameString, "arun");
	        }
	@Test(priority=3)
	 void testJSONOBJECTResponse3()
	 {
		Response response=given()
			           .contentType(ContentType.JSON)
			.when()
			           .get("http://localhost:3000/students");
	     
	    JSONArray jarr = new JSONArray(response.asString());

	    for (int i = 0; i < jarr.length(); i++) {

	        String studentName = jarr.getJSONObject(i).getString("name");
	        System.out.println("Student Name is: " + studentName);
	         
	 }
	 }
}
