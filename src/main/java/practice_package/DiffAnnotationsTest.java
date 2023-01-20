package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DiffAnnotationsTest {
	
	@BeforeClass
	public void configBC() {
		System.out.println("-----launch the browser---");
		
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login to app");
	}
	
	@Test
	public void addClient()
	{
		System.out.println("Add client");
	}

	@AfterMethod
	public void logout()
	{
		System.out.println("logout from the app");
	}
	
	@Test(invocationCount = 2)
	public void addNominee() {
		System.out.println("Add nominee");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("-----close the browser----");
	}

}
