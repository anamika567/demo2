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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.insurance.GenericUtilities.ExcelUtility;
import com.insurance.GenericUtilities.FileUtility;
import com.insurance.GenericUtilities.WebDriverUtility;


public class Payments_Edit_Payment_Test {
public static void main(String[] args) throws Throwable, IOException {
		
	//	FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
	/*	WebDriverUtility wlib=new WebDriverUtility();
		
		
		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");
*/
		
		// step1 : Get Common Data
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData1.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL= p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//String details=elib.readDataFromExcel("Edit_Details", 0, 1);

		// step2 : Read Data From Excel sheet
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Edit_Payments");
		
		// step3 : Login To Application
		WebDriver driver=new ChromeDriver();
		
		
		//wlib.maximizeWindow(driver);

		driver.manage().window().maximize();
		
		//wlib.waitForPageLoad(driver);

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.linkText("PAYMENTS")).click();
		
		String value1 = elib.readDataFromExcel("Edit_Payments", 0, 1);
		driver.findElement(By.xpath("//td[text()='"+value1+"']/following-sibling::td[6]/child::a")).click();
		
		//step 4: get the data
		 Map<String, String> l = elib.getList("Edit_Details", 0, 1);
		
		for(Entry<String, String> entry:l.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			driver.findElement(By.name(key)).clear();
			driver.findElement(By.name(key)).sendKeys(value);

		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//step 5: check data is updated or not
		String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actualData.contains("New record updated"))
		{
			System.out.println("New record updated successfully.");
		}
		else
		{
			System.out.println("New record not updated successfully.");
		}
		
      //step 6: logout from the app
      WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
		
	//	wlib.mousehover(driver, logout);
		
		Actions a=new Actions(driver);
		a.moveToElement(logout);
		logout.click();
		
		// step 7: close the browser
		driver.close();
	}

}
