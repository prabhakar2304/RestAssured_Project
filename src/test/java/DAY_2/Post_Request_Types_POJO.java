package DAY_2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class Post_Request_Types_POJO {
    String id;
	
	//3-->Post request using POJO class
	@Test(priority=1)
	public void testpostusingpojoclass()
	{
		POJO_class pojodata=new POJO_class();
		
		pojodata.setGender("Male");
		pojodata.setName("Honey Singh");
		pojodata.setEnglish("99");
		pojodata.setMaths("100");
		pojodata.setPhysics("80");
	//	data.put("maths", "65");
	//	data.put("physics", "75");
		
		id = given()
		        .contentType("application/json")
		        .body(pojodata)

		    .when()
		        .post("http://localhost:3000/students")

		    .then()
		        .statusCode(201)
		        .body("name", equalTo("Honey Singh"))
		        .body("gender", equalTo("Male"))
		        .body("english", equalTo("99"))
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

