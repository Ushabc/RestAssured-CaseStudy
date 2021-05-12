package utilities;

public class URL {

	public static final String URL="http://rest-api.upskills.in";
	
	public static String getEndPoint()
	{
		return URL;
	}
	
	public static String getEndPoint(String resource)
	{
		return URL + resource;
	}
}
