package project;

import org.testng.Assert;

import io.restassured.response.Response;
import utilities.TestUtil;

public class Assertions {


	public static void verifySuccess(Response response, int success) {
		Assert.assertEquals(TestUtil.getStatusCode(response), success);
		
	}
	

	public static void verifymessage(Response response, String message) {
		Assert.assertEquals(TestUtil.getStatusCode(response), message);
		
	}

}
