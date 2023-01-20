package project_life_insurance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.insurance.GenericUtilities.DatabaseUtility;
import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.JavaUtility;
import com.insurance.GenericUtilities.WebDriverUtility;
import com.insurance.ObjectRepo.AddPaymentPage;
import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.InsertInfoPage;
import com.insurance.ObjectRepo.LoginPage;
import com.insurance.ObjectRepo.PaymentsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Payments_Add_Payment_Using_Pom {

	public static void main(String[] args) throws Throwable {
		
		//step 1: create object of utility file
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//step 2: get the data from property file
		
		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");
		
		//step 3: get the data from excel file
		String id=elib.readDataFromExcel("Payment_details1", 0, 1);
		String month=elib.readDataFromExcel("Payment_details1", 1, 1);
		String amount=elib.readDataFromExcel("Payment_details1", 2, 1);
		String due=elib.readDataFromExcel("Payment_details1", 3, 1);
		String fine=elib.readDataFromExcel("Payment_details1", 4, 1);
		
		// step 4: Launch the browser
		
		WebDriver driver=new ChromeDriver();
		
		wlib.maximizeWindow(driver);
		driver.get(URL);
		wlib.waitForPageLoad(driver);
		
		// step 5: Login to app
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		// step 6: click on Payments link
		HomePage hp=new HomePage(driver);
		hp.getPaymentsLink().click();
				
		// step 7: click on add payment tab
		PaymentsPage pp=new PaymentsPage(driver);
		pp.getAddPaymentBtn().click();
		
		Thread.sleep(1000);
		
		AddPaymentPage ap=new AddPaymentPage(driver);
	    ap.addPaymentDetails(id, month, amount, due, fine);
	    
	    // step 8: verify payment added or not
	    
	    String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actualData.contains("New Payment"))
		{
			System.out.println("New Payment Added.");
		}
		else
		{
			System.out.println("Payment not added.");
		}
		
		// step 9: logout from the app
	    hp.logout();
		
		// step 10: close the browser
		driver.close();	

	}

}
