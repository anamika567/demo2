package project_life_insurance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

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

public class Payments_Add_Payment_System_Test {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		
		String URL = flib.readDataFromPropertyFile("url");
		String USERNAME = flib.readDataFromPropertyFile("username");
		String PASSWORD = flib.readDataFromPropertyFile("password");

		
//		        // step 1: Get Common Data
//				FileInputStream fis =new FileInputStream("./src/test/resources/CommonData1.properties");
//				Properties pObj=new Properties();
//				pObj.load(fis);
//				String URL=pObj.getProperty("url");
//				String USERNAME=pObj.getProperty("username");
//				String PASSWORD=pObj.getProperty("password");
		

			
//				// step 2: Read data from excel sheet
//				FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
//				Workbook wb=WorkbookFactory.create(fi);
//				Sheet sh = wb.getSheet("PaymentDetails");
//				Sheet sh2 = wb.getSheet("PaymentDetails2");
//				
				// step 3: Launch the browser
				
		        //WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				
				wlib.maximizeWindow(driver);
				//driver.manage().window().maximize();

				driver.get(URL);
				
				wlib.waitForPageLoad(driver);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				// step 4: Login to app
				driver.findElement(By.name("username")).sendKeys(USERNAME);
				driver.findElement(By.name("password")).sendKeys(PASSWORD);
				driver.findElement(By.xpath("//button[text()='login']")).click();
				
				// step 5: click on Payments tab
				driver.findElement(By.linkText("PAYMENTS")).click();
				
				// step 6: add payment details
				driver.findElement(By.linkText("Add Payment")).click();
				Thread.sleep(1000);
				
				
				HashMap<String, String> hm=new HashMap<String, String>();
				Map<String, String> l = elib.getList("Payment_details1", 0, 1);
				
				for(Entry<String, String> entry:l.entrySet())
				{
					String key = entry.getKey();
					String value = entry.getValue();
					driver.findElement(By.name(key)).sendKeys(value);

				}

				/*
				ArrayList<String> list=new ArrayList<String>();
				list.add("client_id");
				list.add("month");
				list.add("amount");
				list.add("due");
				list.add("fine");
				
				for(int i=0;i<list.size();i++)
				{
					String value=sh.getRow(i).getCell(1).getStringCellValue();
					driver.findElement(By.name(list.get(i))).sendKeys(value);
					
				}
				*/
				driver.findElement(By.xpath("//input[@type='submit']")).click();
		        
				// step 7: check new payment is added successfully 
				String actualData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
				if(actualData.contains("New Payment"))
				{
					System.out.println("New Payment Added.");
				}
				else
				{
					System.out.println("Payment not added.");
				}
				
				// again add payment
				
				driver.findElement(By.linkText("Add Payment")).click();

				
				HashMap<String, String> hm2=new HashMap<String, String>();
				Map<String, String> l2 = elib.getList("Payment_details2", 0, 1);
				
				for(Entry<String, String> entry2:l2.entrySet())
				{
					String key2 = entry2.getKey();
					String value2 = entry2.getValue();
					driver.findElement(By.name(key2)).sendKeys(value2);

				}

				
				/*
				ArrayList<String> list1=new ArrayList<String>();
				list1.add("client_id");
				list1.add("month");
				list1.add("amount");
				list1.add("due");
				list1.add("fine");
				
				for(int j=0;j<list1.size();j++)
				{
					String value1=sh1.getRow(j).getCell(1).getStringCellValue();
					driver.findElement(By.name(list1.get(j))).sendKeys(value1);
					
				}
				*/
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				Thread.sleep(1000);

				
				// step 7: check new payment is added successfully 
				String actualData1 = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
				if(actualData1.contains("New Payment"))
				{
					System.out.println("New Payment Added.");
				}
				else
				{
					System.out.println("Payment not added.");
				}
				
				
				// step 8: logout from the app
				WebElement logout = driver.findElement(By.xpath("//a[@title='Logout']"));
				
				wlib.mousehover(driver, logout);

				//Actions a=new Actions(driver);
				//a.moveToElement(logout);
				logout.click();
				
				// step 9: close the browser
				driver.close();
				
				
				
				

	}

}
