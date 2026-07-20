package DAY_2;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class Post_Request_Types_HashMap {
    String id;
    
    //1-->Post request using hashmap
	@Test(priority=1)
	void testpostusingHashMap()
	{
		HashMap<String, String> data=new HashMap<>();
		data.put("gender", "Male");
		data.put("name", "Raghav");
		data.put("english", "55");
	//	data.put("maths", "65");
	//	data.put("physics", "75");
		id = given()
		        .contentType("application/json")
		        .body(data)

		    .when()
		        .post("http://localhost:3000/students")

		    .then()
		        .statusCode(201)
		        .body("name", equalTo("Raghav"))
		        .body("gender", equalTo("Male"))
		        .body("english", equalTo("55"))
		        .extract()
		        .path("id");

		System.out.println(id);		
}
	
	
	 @Test(priority=2)
	void testDeleteRequest()
	{
		given()
		//.header("x-api-key", apiKey)
		
		.when()
		.delete("http://localhost:3000/students/"+id)
		
		.then()
	    .statusCode(200)
	    .log().all();
	}
	
}

