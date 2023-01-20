package practise_package_assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Population_Capture {
	
	static WebDriver driver;
     public static void main(String[] args) throws IOException   {
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.worldometers.info/world-population/");
		takeScreenshot("worldpopulation1");
		driver.close();
		
		}		

	
	public static void takeScreenshot(String fileName) throws IOException 
	{
	TakesScreenshot t=(TakesScreenshot) driver;
	File file=t.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, new File("C:\\Users\\hp\\eclipse-workspace\\com.crm.Vtiger\\Screenshot"+fileName+".png"));
	}

	
	}


