package DAY_1;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class HTTPRequestTest {
	
	/**
	 * Test a public REST API endpoint using JSONPlaceholder
	 * JSONPlaceholder is a free REST API for testing
	 */
	@Test
	public void TestGetPostsEndpoint() {
		given()
			.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
			.then()
			.statusCode(200)
			.body("id", equalTo(1))
			.body("title", notNullValue())
			.log().all();
	}
	
	@Test
	public void TestGetUsersEndpoint() {
		given()
			.when()
			.get("https://jsonplaceholder.typicode.com/users")
			.then()
			.statusCode(200)
			.body("size()", greaterThan(0))
			.log().all();
	}
	
	@Test
	public void TestGetSingleUserEndpoint() {
		given()
			.when()
			.get("https://jsonplaceholder.typicode.com/users/1")
			.then()
			.statusCode(200)
			.body("id", equalTo(1))
			.body("name", notNullValue())
			.log().all();
	}

}
