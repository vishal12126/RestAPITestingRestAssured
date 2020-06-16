package test.enterworks.epim.rest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetAccessToken
{
    public GetAccessToken(){
    }
    
    // login using system user
    public String getTokenLoginSystemUser()  throws Exception
    {
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    	String url = "http://localhost:8090/myapi/rest/oauth/token?"; // sample URL to get the token
    	
    	String baseToken = "Basic authpassword";
    	
    	URIBuilder builder = new URIBuilder(url);

    	builder.setParameter("allowexpire", "true");
    	builder.setParameter("grant_type", "password");
    	builder.setParameter("username", "user");
    	builder.setParameter("password", "password");
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
    	 JsonParser parser = new JsonParser();
    	 JsonObject jsonObject = parser.parse(responseString).getAsJsonObject();
    	 String token = jsonObject.get("access_token").getAsString();
    	 System.out.println("token =>  " + token);
    	 
         return token;

    }
}
