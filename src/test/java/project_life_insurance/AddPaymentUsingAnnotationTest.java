package project_life_insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.insurance.GenericUtilities.BaseClass;
import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.WebDriverUtility;
import com.insurance.ObjectRepo.AddPaymentPage;
import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.PaymentsPage;

@Listeners(com.insurance.GenericUtilities.ListenerImplimentationClass.class)
public class AddPaymentUsingAnnotationTest extends BaseClass {
	
	
	@Test(groups = "smoke")
	public void addPayment() throws Throwable { 

			//step 1: get the data from excel file
			String id=elib.readDataFromExcel("Payment_details1", 0, 1);
			String month=elib.readDataFromExcel("Payment_details1", 1, 1);
			String amount=elib.readDataFromExcel("Payment_details1", 2, 1);
			String due=elib.readDataFromExcel("Payment_details1", 3, 1);
			String fine=elib.readDataFromExcel("Payment_details1", 4, 1);
		
			
			// step 2: click on Payments link
			
			HomePage hp=new HomePage(driver);
			hp.getPaymentsLink().click();
					
			// step 3: click on add payment tab
			
			PaymentsPage pp=new PaymentsPage(driver);
			pp.getAddPaymentBtn().click();
			Assert.fail();
			
			AddPaymentPage ap=new AddPaymentPage(driver);
		    ap.addPaymentDetails(id, month, amount, due, fine);
		    
		    // step 4: verify payment added or not
		    
		    String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
			if(actualData.contains("New Payment"))
			{
				System.out.println("New Payment Added.");
			}
			else
			{
				System.out.println("Payment not added.");
			}
			
		}
	
	
	@Test
	public void simple() {
		System.out.println("ts");
	}
	
	
	@Test
	public void simple2() {
		System.out.println("ts");
	}
	

}
