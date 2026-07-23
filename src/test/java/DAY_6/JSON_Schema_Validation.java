package DAY_6;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSON_Schema_Validation 
{
	@Test(priority=1)
	void testJSONSchemaValidation()
	{
    given()
		
		.when()
			.get("http://localhost:3000/students")
			
	    .then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"));
	}
}
