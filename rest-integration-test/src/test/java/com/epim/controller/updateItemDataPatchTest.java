package test.enterworks.epim.rest.controllers;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import test.enterworks.epim.rest.controllers.GetAccessToken;
import io.restassured.http.ContentType;

public class updateItemDataPatchTest {
	GetAccessToken getToken = new GetAccessToken();
	
	@Test
    public void updateItemDataUsingPatchTest() {
        String token = null;
        String jsonString = "{\"F_1004616\": \"12345\"}";
      //  RestAssured.baseURI = "http://localhost:8090";
		try {
			token = getToken.getTokenLoginSystemUser();
		} catch (Exception e) {
			e.printStackTrace();
		}        
        //GIVEN
		RestAssured
			.given().header("Authorization", "Bearer "+token)
					.contentType(ContentType.JSON)
					.body(jsonString)
					// WHEN
					.when()
							.patch("http://localhost:8090/webcm/rest/api/items/5692007")
					// THEN
					.then()
							.assertThat()
							.statusCode(200);
    }
}