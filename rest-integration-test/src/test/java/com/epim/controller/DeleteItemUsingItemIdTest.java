package test.enterworks.epim.rest.controllers;

import org.junit.Test;

import io.restassured.RestAssured;
import test.enterworks.epim.rest.controllers.GetAccessToken;
import org.hamcrest.Matchers;

public class DeleteItemUsingItemIdTest {
	GetAccessToken getToken = new GetAccessToken();
	
	@Test
    public void deleteItemDataUsingPostTest() {
        String token = null;
       // RestAssured.baseURI = "http://localhost:8090";
		try {
			token = getToken.getTokenLoginSystemUser();
		} catch (Exception e) {
			e.printStackTrace();
		}        
        //GIVEN
		RestAssured
			.given().header("Authorization", "Bearer "+token)
					// WHEN
					.when()
							.delete("http://localhost:8090/webcm/rest/api/items/5868852")
					// THEN
					.then()
							.assertThat()
							.statusCode(200)
							.body("status", Matchers.equalTo(0));
    }
}
