package project_life_insurance;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Payments_Delete_Payment_Test {
	
	public static void main(String[] args)throws Throwable {
		
        // step1 : Get Common Data
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData1.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url= p.getProperty("url");
		String Username = p.getProperty("username");
		String Password = p.getProperty("password");
		
		// step2 : Read Data From Excel sheet
		FileInputStream fiss=new FileInputStream("./src/test/resources/TestData45.xlsx");
		Workbook wb=WorkbookFactory.create(fiss);
		Sheet s = wb.getSheet("Delete_Payments");
		
		// step3 : Login To Application
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Url);
		driver.findElement(By.name("username")).sendKeys(Username);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.xpath("//button[.='login']")).click();
		driver.findElement(By.linkText("PAYMENTS")).click();
		
		String value  = s.getRow(0).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//td[text()='"+value+"']/following-sibling::td[6]/child::a")).click();
		driver.findElement(By.name("recipt_no")).sendKeys(value);
		driver.findElement(By.linkText("Delete Payment")).click();
		
		// step4 : Check Payment Deleted or Not
		String actData = driver.findElement(By.xpath("//div[@class='col-md-12']")).getText();
		if(actData.contains("Record deleted"))
		{
		System.out.println("Record deleted successfully");
		}
		else 
		{
		System.out.println("Payment not deleted");
		}
		
		// step5 : Logout from Application
		  driver.findElement(By.xpath("//a[@title='Logout']")).click();
		  driver.close();
		

	}

}
