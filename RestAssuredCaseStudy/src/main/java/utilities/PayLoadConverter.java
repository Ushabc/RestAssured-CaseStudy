package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadConverter {
static 
	public String generatepayloadstring(String filename) throws IOException
	{
		String filepath = "C:\\Users\\UshaBC\\Documents\\Full Stack\\RestAssuredCaseStudy\\resource\\" +filename;
//		String filepath = System.getProperty("user.dir")+"\\resource\\"+filename;
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}
}
