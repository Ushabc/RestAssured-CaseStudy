package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtil {

	public static String getResponseString(Response response)
	{
		String strres=response.getBody().asString();
		return strres;
		
	}
	
	public static JsonPath jsonParser(String response)
	{
		JsonPath jres= new JsonPath(response);
		return jres;
		
	}
	
	public static XmlPath xmlOParser(String response)
	{
		XmlPath xmlresp= new XmlPath(response);
		return xmlresp;
		
	}
	
	public static int getStatusCode(Response response)
	{
		int status =response.getStatusCode();
		return status;
		
	}
	public static String getStatusMessage(Response response)
	{
		String message =response.getStatusLine();
		return message;
		
	}
}
