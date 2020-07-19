package test.enterworks.epim.rest.controllers;


import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import test.enterworks.epim.rest.controllers.GetAccessToken;


public class RepositoryControllerTest {
	GetAccessToken getToken = new GetAccessToken();
	
	@Test
    public void getRepositoryDatabyRepoIdTest() {
        String token = null;
		try {
			token = getToken.getTokenLoginSystemUser();
		} catch (Exception e) {
			e.printStackTrace();
		}        
        int responseInt = RestAssured.given().header("Authorization", "Bearer "+token).when().get("http://localhost:8090/webcm/rest/api/repositories").getStatusCode();
        System.out.println("response: " +responseInt);
        Assert.assertEquals(responseInt, 200);
    }
}
