package project_life_insurance;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.insurance.GenericUtilities.BaseClass;
import com.insurance.ObjectRepo.EditPaymentPage;
import com.insurance.ObjectRepo.HomePage;

public class EditPaymentUsingAnnotationTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void editPayment() throws Throwable {
	
			//step 1: get the data from excel file
			
	        String RECIPT_NO = elib.readDataFromExcel("Edit_Payments", 0, 1);
			
			String month=elib.readDataFromExcel("Edit_Details", 0, 1);
			String amount=elib.readDataFromExcel("Edit_Details", 1, 1);
			String due=elib.readDataFromExcel("Edit_Details", 2, 1);
			String fine=elib.readDataFromExcel("Edit_Details", 3, 1);
			
						
			// step 2: click on Payments link

			HomePage hp=new HomePage(driver);
			hp.getPaymentsLink().click();
			
			
			// step 3: click on Edit payment tab

			EditPaymentPage ed=new EditPaymentPage(driver);
			ed.editPayment(driver, RECIPT_NO);
			ed.setValue(month, amount, due, fine);
			
		    // step 4: verify payment added or not
			
			String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
			if(actualData.contains("New record updated"))
			{
				System.out.println("New record updated successfully.");
			}
			else
			{
				System.out.println("New record not updated successfully.");
			}
			
	        
		}


}
