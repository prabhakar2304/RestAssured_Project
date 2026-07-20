package DAY_2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class Post_Request_Types_JSON {
	String id;
	
	//2-->Post request using org.json library
	@Test(priority=1)
	public void testpostusingorgjson()
	{
		JSONObject jdata=new JSONObject();
		
		jdata.put("gender", "Male");
		jdata.put("name", "YO! YO!");
		jdata.put("english", "55");
	//	data.put("maths", "65");
	//	data.put("physics", "75");
		
		id = given()
		        .contentType("application/json")
		        .body(jdata.toString())

		    .when()
		        .post("http://localhost:3000/students")

		    .then()
		        .statusCode(201)
		        .body("name", equalTo("YO! YO!"))
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

