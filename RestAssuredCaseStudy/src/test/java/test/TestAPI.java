package test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import project.Assertions;
import project.BaseTest;
import project.RestCalls;
import utilities.PayLoadConverter;
import utilities.TestUtil;
import utilities.URL;

public class TestAPI {
	
	private String accessToken;
	static Response response;
	@BeforeTest
	public void setup() throws IOException
	{
		accessToken=BaseTest.Authorization();
	}

	@Test(priority=0)
	public void Login() throws IOException
	{
//		Go to resource and fetch the payload and convert it to string
		String loginPayLoad =  PayLoadConverter.generatepayloadstring("login.json");
		//fetch the url along with resource
		String endPointURI=URL.getEndPoint("/api/rest_admin/login");
		response=RestCalls.PostRequest(endPointURI,loginPayLoad,accessToken);
		String strres=response.getBody().asString();
		JsonPath jsonresp= new JsonPath(strres);
		String success = jsonresp.getString("success");
		System.out.println(success);
		Assertions.verifySuccess(response, 200);
		
	}
	
	@Test(priority=1)
	public void getUser() throws IOException
	{
		//fetch the url along with resource
		String endPointURI=URL.getEndPoint("/api/rest_admin/user");
		response=RestCalls.GetRequest(endPointURI,accessToken);
		String strres=response.getBody().asString();
		JsonPath jsonresp= new JsonPath(strres);
		String success = jsonresp.getString("success");
		System.out.println(success);
		Assertions.verifySuccess(response, 200);
		
	}
	@Test(priority=2)
	public void getCustomersBetween() throws IOException
	{

		String endPointURI=URL.getEndPoint("/api/rest_admin/customers/added_from/{added_from}/added_to/{added_to}");
		response=RestCalls.GetRequestWithParameter(endPointURI,accessToken,"added_from","2019-11-20","added_to","2019-11-30");
		String strres=response.getBody().asString();
		JsonPath jsonresp= new JsonPath(strres);
		String success = jsonresp.getString("success");
		System.out.println(success);
		Assertions.verifySuccess(response, 200);
		
	}
	
	@Test(priority=3)
	public void logout()
	{
		//fetch the url along with resource
		String endPointURI=URL.getEndPoint("/api/rest_admin/logout");
		response=RestCalls.PostRequest1(endPointURI,accessToken);
		String strres=response.getBody().asString();
		JsonPath jsonresp= new JsonPath(strres);
		String success = jsonresp.getString("success");
		System.out.println(success);
		Assertions.verifySuccess(response, 200);
	}

}
