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

import org.testng.annotations.Test;

//XML Response
public class Demo6_BasicValidations_XML {

	//1 Verifying single content respinse in xml response

	@Test(priority=1)
	void testSingleContent()
	{
		given()

		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.log().all();
	}

	//Verifying multipleContecnt in xml response

	@Test(priority=2)
	void testMultipleContent()
	{
		given()

		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

		.then()
		.body("CUSTOMER.ID", equalTo("15"))
		.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
		.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
		.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
		.body("CUSTOMER.CITY", equalTo("Seattle"));
	}


	//Verifying multipleContecnt in xml response in one go
	@Test(priority=3)
	void testMultipleContentInOneGo()
	{
		given()

		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

		.then()
		.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
		;
	}

	//finding the value in xml response 

	@Test(priority=4)
	void testUsingXpath1()
	{
		given()

		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")

		.then()
		.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	}
	
	@Test(priority=5)
	void testUsingXpath2()
	{
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/INVOICE/")

		.then()
		.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
		.log().all();
	}



}
