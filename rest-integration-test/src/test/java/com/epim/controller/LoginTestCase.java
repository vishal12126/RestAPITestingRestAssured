package test.enterworks.epim.rest.controllers;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

//import test.enterworks.epim.rest.ApiTestUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LoginTestCase extends TestCase
{
    public LoginTestCase(String name){
        super(name);
    }
    
    public static Test suite()
    {
        TestSuite ts = new TestSuite();
        ts.addTest(new LoginTestCase("testLoginSystemUser"));
        
        return ts;
    }
    
    // login using system user
    public void testLoginSystemUser()  throws Exception
    {
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    	String url = "http://localhost:8090/webcm/rest/oauth/token?";
    	
    	String baseToken = "Basic ZXBpbS1jbGllbnQ6ZXBpbS1jbGllbnQ=";
    	
    	URIBuilder builder = new URIBuilder(url);

    	builder.setParameter("allowexpire", "true");
    	builder.setParameter("grant_type", "password");
    	builder.setParameter("username", "system");
    	builder.setParameter("password", "system");
    	builder.setParameter("language", "en");

    	 
        HttpPost post = new HttpPost(builder.build());
        post.addHeader("Authorization", baseToken);
    	     	 
    	// Post the request and check the response
    	HttpResponse response = httpClient.execute(post);    	
    	 
    	 // Now let us print the body of the message to see what response
    	 // we have received from the server
    	 HttpEntity responseBody = response.getEntity();
    	 String responseString = EntityUtils.toString(responseBody, "UTF-8");
    	 System.out.println("Response Body is =>  " + responseString);
    	 

    	 StatusLine statusCode = response.getStatusLine();
    	 System.out.println("Response status is =>  " + statusCode.getStatusCode() + "; " + statusCode.toString());


    }
    


}
