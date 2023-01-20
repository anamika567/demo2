package project_life_insurance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.insurance.GenericUtilities.BaseClass;
import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.WebDriverUtility;
import com.insurance.ObjectRepo.AddPaymentPage;
import com.insurance.ObjectRepo.EditPaymentPage;
import com.insurance.ObjectRepo.HomePage;
import com.insurance.ObjectRepo.PaymentsPage;

public class DeletePaymentUsingAnnotationTest extends BaseClass{
	
	@Test(groups = "regression")
	public void deletePayment() throws Throwable {
	
	//step 1: get the data from excel file
	
    String RECIPT_NO = elib.readDataFromExcel("Delete_Payments", 0, 1);
    
	// step 2: click on Payments link
	
	HomePage hp=new HomePage(driver);
	hp.getPaymentsLink().click();
	
	// step 3: click on Edit payment tab
	
	EditPaymentPage ep=new EditPaymentPage(driver);
	ep.deletePayment(driver,RECIPT_NO);
	
	// step 4: Check Payment Deleted or Not
	
	String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
	if(actData.contains("Record deleted"))
	{
	System.out.println("Record deleted successfully");
	}
	else 
	{
	System.out.println("Record not deleted");
	}
	
	
	
}


}
