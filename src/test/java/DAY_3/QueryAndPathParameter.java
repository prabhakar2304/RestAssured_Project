package DAY_3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class QueryAndPathParameter {
	String apiKey = "pub_07208d8e904ad1680b8dbbb124acb8f8380f227734d5220928bc06b974bc683e";
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryAndPathParameter()
	{
		given()
		.header("x-api-key", apiKey)
		.pathParam("mypath","users") 
		.queryParam("page", 2)     //page=2&id=5
		.queryParam("id", 5)       //page=2&id=5
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
           .statusCode(200)	
		   .log().all();
	
	}
}
