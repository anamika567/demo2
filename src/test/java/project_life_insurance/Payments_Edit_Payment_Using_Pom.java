package project_life_insurance;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.WebDriverUtility;
import com.insurance.ObjectRepo.EditPaymentPage;
import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.LoginPage;

public class Payments_Edit_Payment_Using_Pom {

	public static void main(String[] args) throws Throwable, IOException {
		
		//step 1: create object of utility file

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//step 2: get the data from property file

		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");
		
		//step 3: get the data from excel file
		
        String RECIPT_NO = elib.readDataFromExcel("Edit_Payments", 0, 1);
		
		String month=elib.readDataFromExcel("Edit_Details", 0, 1);
		String amount=elib.readDataFromExcel("Edit_Details", 1, 1);
		String due=elib.readDataFromExcel("Edit_Details", 2, 1);
		String fine=elib.readDataFromExcel("Edit_Details", 3, 1);
		
		// step 4: Launch the browser

		WebDriver driver=new ChromeDriver();
		
		wlib.maximizeWindow(driver);

	    //driver.manage().window().maximize();
		
		wlib.waitForPageLoad(driver);

		driver.get(URL);
		
		// step 5 : Login To Application

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		// step 6: click on Payments link

		HomePage hp=new HomePage(driver);
		hp.getPaymentsLink().click();
		
		
		// step 7: click on Edit payment tab

		EditPaymentPage ed=new EditPaymentPage(driver);
		ed.editPayment(driver, RECIPT_NO);
		ed.setValue(month, amount, due, fine);
		
	    // step 8: verify payment added or not
		String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actualData.contains("New record updated"))
		{
			System.out.println("New record updated successfully.");
		}
		else
		{
			System.out.println("New record not updated successfully.");
		}
		
        //step 9: logout from the app
		
		hp.logout();
  	
	  // step 10: close the browser
		driver.close();
		
	

	}

}
