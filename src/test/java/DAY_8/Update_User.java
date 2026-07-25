package DAY_8;

import org.codehaus.groovy.runtime.memoize.MemoizeCache.ValueProvider;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;
import com.github.javafaker.Faker;

public class Update_User 
{ @Test(priority=1)

void testupdateUser(ITestContext context)
{
	Faker fkFaker=new Faker();
	JSONObject jObject=new JSONObject();
	jObject.put("name",fkFaker.name().fullName());
	jObject.put("Gender", "Male");
	jObject.put("email",fkFaker.internet().emailAddress());
	jObject.put("status", "inactive");
	
	String bearertoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	int id=(Integer) context.getAttribute("user_id");
	
	given()
	.header("Authorization","Bearer "+bearertoken)
	.contentType("application/json")
	.body(jObject.toString())
	.pathParam("id", id)
	
	.when()
	.put("https://gorest.co.in/public/v2/users/{id}")
	
	.then()
	 .statusCode(200)
	 .log().all();
}

}
