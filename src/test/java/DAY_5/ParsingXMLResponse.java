package DAY_5;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class ParsingXMLResponse {
	@Test(priority=1)  //Approach 1
	void testXMLResponse()
	{
		given()
		
		.when()
			.get("https://www.w3schools.com/xml/note.xml")
			
	    .then()
			.statusCode(200)
			.header("Content-Type", "text/xml")
			.body("note.to", equalTo("Tove"));
     }
	@Test(priority=2)  //Approach 2
	void testXMLResponse2()
	{
		Response response=given()
		
		.when()
			.get("https://www.w3schools.com/xml/note.xml");
			
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.getHeader("Content-Type"), "text/xml");
		String string=response.xmlPath().getString("note.body");
		   System.out.println("Value of note.to is: "+string);
		   Assert.assertEquals(string, "Don't forget me this weekend!");
     }
	@Test(priority=3) //Approach 3
	
	
	void testXMLResponse3()
	{
		Response response=given()
		
		.when()
			.get("https://www.w3schools.com/xml/note.xml");
			
		XmlPath xmlpath = new XmlPath(response.asString());
	    List <String> l=xmlpath.getList("note");
		System.out.println("Size of List is: "+l.size());
}
}
