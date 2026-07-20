package DAY_2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class Post_Request_types_External_JSON {
	
    String id;
	
	//2-->Post request using External JSON file
	@Test(priority=1)
	public void testpostusingexternaljson() throws Exception
	{
		File file=new File(".\\Body.JSON");
		
		FileReader fr=new FileReader(file);
		
		JSONTokener JT=new JSONTokener(fr);
		
		JSONObject jdata=new JSONObject(JT);
		
	/*	jdata.put("gender", "Male");
		jdata.put("name", "NEW ENTRY");
		jdata.put("english", "75");
	//	data.put("maths", "65");
	//	data.put("physics", "75"); */
		
		id = given()
		        .contentType("application/json")
		        .body(jdata.toString())

		    .when()
		        .post("http://localhost:3000/students")

		    .then()
		        .statusCode(201)
		        .body("name", equalTo("rajesh"))
		        .body("gender", equalTo("Male"))
		        .body("english", equalTo(95))
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
