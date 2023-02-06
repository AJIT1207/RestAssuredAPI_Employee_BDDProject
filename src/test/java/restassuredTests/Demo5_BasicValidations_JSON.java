package restassuredTests;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;


import org.junit.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Demo5_BasicValidations_JSON {
	
	
	//1 status code
	@Test(priority=1)
	public void testStatusCode()
	{
		given()
		.when()
				.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//2 Log response
	@Test(priority=2)
	public void testlogging()
	{
		given()
		.when()
		.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then();
	
	}
	
	@Test(priority=3)
	public void testMultipleContents()
	{
		given()
		.when()
		.get("http://services.groupkt.com/country/get/iso2code/IN")
		.then()
			.body("RestResponse.result.name", hasItems("India","Austrailia"));
	
	}
	
	
	
	
	

}
