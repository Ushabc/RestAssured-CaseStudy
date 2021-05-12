package project;


import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import project.RestCalls;
import utilities.PayLoadConverter;
import utilities.URL;

public class BaseTest {
	private static String authorization;
	 static Response response;
	private static String accessToken;
	 @BeforeTest
	public static String Authorization() 
	{

			//fetch the url along with resource
			String endPointURI=URL.getEndPoint("/api/rest_admin/oauth2/token/client_credentials");
			response = RestCalls.PostRequestforAuthorization(endPointURI,authorization);
			String strres=response.getBody().asString();
			JsonPath jsonresp= new JsonPath(strres);
			String accessToken = jsonresp.getString("data.access_token");
			System.out.println(accessToken);
			Assertions.verifySuccess(response, 200);
			return accessToken;
	}

	

}
