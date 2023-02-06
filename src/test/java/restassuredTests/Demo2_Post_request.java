package restassuredTests;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import java.util.HashMap;


import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_Post_request {

	public static HashMap map = new HashMap();
	
	@BeforeClass
	public void postdata()
	{
		map.put("name", RestUtils.getName());
		map.put("job", RestUtils.getJob());
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users";
	
	}
	
	@Test
	public void testPost()
	{
		given()
				.contentType("application/json")
				.body(map)
		
		.when()	
				.post()
			
		.then()
				.statusCode(201)
				.and()
				.body("SuccessCode",equalTo("OPERATION_SUCCESS"));
	}
}
