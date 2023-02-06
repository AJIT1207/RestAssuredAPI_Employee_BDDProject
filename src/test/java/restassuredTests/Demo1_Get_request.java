package restassuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class Demo1_Get_request 
{
	@Test
	public void getUserDetails()
	{
		given()
		.when()
			.get("https://gorest.co.in/public/v2/users/3310")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("name", equalTo("Gita Desai Jr."))
			.header("Content-Type","application/json; charset=utf-8");
	}



}
