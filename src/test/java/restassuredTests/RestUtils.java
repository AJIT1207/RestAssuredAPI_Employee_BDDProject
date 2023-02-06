package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Ajit"+generatedString);
		
	}
	
	public static String getJob()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Software"+generatedString);
		
	}

}
