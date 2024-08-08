package com.restassured;

import org.testng.annotations.Test;
 import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
 import static org.hamcrest.Matchers.*;

public class RestAssuredImplementationClass {
	@Test
	void getUser() {
		
		given()
		
		.when()
				.get("https://demo.itlearn360.com/")
		
		.then()
				.statusCode(200)
				.log().all();
	}


}
