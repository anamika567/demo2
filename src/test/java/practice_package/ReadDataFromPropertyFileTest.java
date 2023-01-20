package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		
		// step 1:get object representation for physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		
		// step 2:Create object for properties
		Properties pObj=new Properties();
		
		// step 3:Load the file
		pObj.load(fis);
		
		// step 4:Read the data 
		
		String URL=pObj.getProperty("url");
		String BROWSER=pObj.getProperty("browser");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		

	}

}
