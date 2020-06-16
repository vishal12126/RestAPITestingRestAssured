package com.epim.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class RepositoryControllerTest {

	@BeforeAll
	static void setup() {
		//LOG.info("@BeforeAll - executes once before all test methods in this class");
	}

	@Test
	public void getRepositoryListTest() {
		
		given().header("Authorization", "Bearer " + token)
		.when().get("URL").then().
		  assertThat().statusCode(200);
		 }
	
	@Test
	public void getRepositoryListGroupsTest() {
		
		given().header("Authorization", "Bearer " + token)
		.when().get("URL").then().
		  assertThat().statusCode(200);
		 }
}
