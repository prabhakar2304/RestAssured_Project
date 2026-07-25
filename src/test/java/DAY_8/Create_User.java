package DAY_8;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.ITestContext;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

public class Create_User 
{ @Test(priority=1)
	void testCreateUser(ITestContext context)
	{
	Faker fkFaker=new Faker();
	JSONObject jObject=new JSONObject();
	jObject.put("name",fkFaker.name().fullName());
	jObject.put("Gender", "Male");
	jObject.put("email",fkFaker.internet().emailAddress());
	jObject.put("status", "inactive");
	
	String bearertoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	
	     int id=  given()
			.header("Authorization","Bearer "+bearertoken)
			.contentType("application/json")
			.body(jObject.toString())
			
			.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
	     
	     context.setAttribute("user_id", id);
	
	}

}
