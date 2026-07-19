package DAY_1;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class HTTPRequest {
	String apiKey = "pub_07208d8e904ad1680b8dbbb124acb8f8380f227734d5220928bc06b974bc683e";
	int id;
	 @Test(priority=1)
	public void getUers() {
		 
		given()
		.header("x-api-key", apiKey)
	    .when()
	  .get("https://reqres.in/api/users?page=2")
	   .then()
	   .statusCode(200)
	   .log().all();

	}
	@Test(priority=2)
	public void createUser()
	{
		HashMap<String, String> hMap=new HashMap<>();
		hMap.put("job", "trainer");
		hMap.put("name", "Raghav");
		
	id=given()
	.header("x-api-key", apiKey)
	.contentType("application/json")
	.body(hMap)
	
	.when()
	.post("https://reqres.in/api/users")
	.jsonPath().getInt("id");
	/*.then()
    .statusCode(201)
    .log().all();*/
	}
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateUser()
	{
		
		HashMap<String, String> hMap=new HashMap<>();
		hMap.put("job", "teacher");
		hMap.put("name", "Raghav");
		
		given()
		.header("x-api-key", apiKey)
		.contentType("application/json")
		.body(hMap)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
	    .statusCode(200)
	    .log().all();
	}
	@Test(priority=4,dependsOnMethods= {"createUser"})
	void deleteUser()
	{
		given()
		.header("x-api-key", apiKey)
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
	    .statusCode(204)
	    .log().all();
	}
}