package project_life_insurance;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.DelegateFileFilter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.Duration;
import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.WebDriverUtility;
import com.insurance.ObjectRepo.EditPaymentPage;
import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.LoginPage;

public class Payments_Delete_Payment_Using_Pom {

	public static void main(String[] args)throws Throwable {
		
		//step 1: create object of utility file

		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//step 2: get the data from property file

		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");
		
		//step 3: get the data from excel file
		
        String RECIPT_NO = elib.readDataFromExcel("Delete_Payments", 0, 1);
        
		// step 4: Launch the browser
        
		WebDriver driver=new ChromeDriver();
		
		wlib.maximizeWindow(driver);

		
		wlib.waitForPageLoad(driver);

		driver.get(URL);
		
		// step 5 : Login To Application
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		// step 6: click on Payments link
		
		HomePage hp=new HomePage(driver);
		hp.getPaymentsLink().click();
		
		
		// step 7: click on Edit payment tab
		EditPaymentPage ep=new EditPaymentPage(driver);
		Thread.sleep(5000);
		ep.deletePayment(driver, RECIPT_NO);
		
		// step 8 : Check Payment Deleted or Not
		String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actData.contains("Record deleted"))
		{
		System.out.println("Record deleted successfully");
		}
		else 
		{
		System.out.println("Record not deleted");
		}
		
        //step 9: logout from the app
		
		hp.logout();
		
		// step 10: close the browser
		
		driver.close();
	}

}
