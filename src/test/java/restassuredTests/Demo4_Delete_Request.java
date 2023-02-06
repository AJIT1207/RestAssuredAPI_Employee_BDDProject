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

public class Demo4_Delete_Request {
	
	@Test
	public void deleteEmprecord()
	{
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/2";
		
		Response response = 
		given()
			
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonasstring = response.asString();
		System.out.println(jsonasstring);
		Assert.assertEquals(jsonasstring.contains("successfully! deleted records"),true);
			
	
	}

}
