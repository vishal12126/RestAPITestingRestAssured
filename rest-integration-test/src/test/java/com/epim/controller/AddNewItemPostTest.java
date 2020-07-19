package test.enterworks.epim.rest.controllers;

import org.junit.Test;

import io.restassured.RestAssured;
import test.enterworks.epim.rest.controllers.GetAccessToken;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

public class AddNewItemPostTest {
	GetAccessToken getToken = new GetAccessToken();
	
	@Test
    public void addItemDataUsingPostTest() {
        String token = null;
        //RestAssured.baseURI = "http://localhost:8090";
        String jsonString = "{\"F_1004613\":\"35\",\"F_1004615\":\"automobiles\",\"F_1004616\":\"1298\",\"F_1004614\":19,\"F_1004618\":1234566}";
		try {
			token = getToken.getTokenLoginSystemUser();
		} catch (Exception e) {
			e.printStackTrace();
		}        
        //GIVEN
		RestAssured
			.given().header("Authorization", "Bearer "+token)
					.queryParam("repositoryId", 10143)
					.contentType(ContentType.JSON)
					.body(jsonString)
					// WHEN
					.when()
							.post("http://localhost:8090/webcm/rest/api/items")
					// THEN
					.then()
							.assertThat()
							.statusCode(201)
							.body("status", Matchers.equalTo(0));
    }
}
