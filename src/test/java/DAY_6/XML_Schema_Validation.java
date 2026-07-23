package DAY_6;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.*;

import io.restassured.matcher.RestAssuredMatchers;

public class XML_Schema_Validation {
	
	@Test(priority=1)
	void testXMLSchemaValidation()
	{
	given()
		
		.when()
			.get("https://www.w3schools.com/xml/note.xml")
			
	    .then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("note_schema.xsd"));
	}
}
