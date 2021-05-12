package project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	
	public static Response GetRequestWithParameter(String URI, String accessToken,String parameterName, Object parameterValue,String parameterName1, Object parameterValue2)
	{
		RequestSpecification requestspecification=RestAssured.given();
		requestspecification.given().header("Authorization","bearer "+accessToken).pathParam(parameterName, parameterValue).pathParam(parameterName1, parameterValue2);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(URI);
		return response;
	}
	
	public static Response GetRequest(String URI, String accessToken)
	{
		RequestSpecification requestspecification=RestAssured.given().header("Authorization","bearer "+accessToken);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(URI);
		return response;
	}
	public static Response PostRequestforAuthorization(String URI,String authorization)
	{
		RequestSpecification requestspecification=RestAssured.given().header("Authorization","Basic "+"dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=");
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(URI);
		return response;
	}
	
	public static Response PostRequest1(String URI, String accessToken)
	{
		RequestSpecification requestspecification=RestAssured.given().header("Authorization","bearer "+accessToken);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(URI);
		return response;
	}
	public static Response GetRequestWithHeader(String URI,String accessToken)
	{
		RequestSpecification requestspecification=RestAssured.given().header("Authorization","bearer "+accessToken);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(URI);
		return response;
	}
	
	public static Response PostRequest(String URI,String strJSON,String accessToken)
	{
		RequestSpecification requestspecification=RestAssured.given().body(strJSON);
		requestspecification.given().header("Authorization","bearer "+accessToken);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(URI);
		return response;	
	}
	public static Response PutRequest(String URI,String strJSON)
	{

		RequestSpecification requestspecification=RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.put(URI);
		return response;
	}
	public static Response DeleteRequest(String URI,String strJSON)
	{

		RequestSpecification requestspecification=RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.delete(URI);
		return response;
	}

	

}
