package DAY_8;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class Delete_User 
{@Test(priority = 1)
void testdeleteUser(ITestContext context)
{
	String bearertoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	int id=(Integer) context.getAttribute("user_id");
	
	 given()
	   .header("Authorization","Bearer "+bearertoken)
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		 .statusCode(204)
		 .log().all();
}
	

}
