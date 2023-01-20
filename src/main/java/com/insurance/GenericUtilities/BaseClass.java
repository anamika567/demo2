package com.insurance.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  WebDriver driver;
	public static WebDriver sdriver;
	public DatabaseUtility dlib=new DatabaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void configDB() throws Throwable
	{
	   dlib.connectToDB("projects");
	   System.out.println("Connect to DB");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression"})
	public void configBC() throws Throwable
	{
		String BROWSER=flib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();

		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
		
		String URL=flib.readDataFromPropertyFile("url");
		
		sdriver=driver;
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		System.out.println("Launch the browser");
			
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws Throwable
	{
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login to app");
		
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void configAM()
	{
		HomePage hp=new HomePage(driver);
		hp.logout();
		System.out.println("Logout from the App");
		
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void configAC()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void disconnectDB() throws Throwable
	{
		dlib.closeDB();
		System.out.println("Disconnect the DB");
	}
	

}
