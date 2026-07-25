package DAY_8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import static io.restassured.matcher.RestAssuredMatchers.*;


 public class Get_User 
 { @Test(priority=1)
  void testgetUser(ITestContext context)
 {
   int id=(Integer) context.getAttribute("user_id");
   String bearertoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
   
   given()
   .header("Authorization","Bearer "+bearertoken)
	.pathParam("id", id)
	
	.when()
	.get("https://gorest.co.in/public/v2/users/{id}")
	
	.then()
	 .statusCode(200)
	 .log().all();
	
	 
	 
	 
 }
	

 }
