package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redbus {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		
		driver.findElement(By.xpath("//label[text()='source']")).click();
		
		WebElement data = driver.findElement(By.xpath("//input[@id='src']"));
		Thread.sleep(2000);
		data.sendKeys("Delhi");
         driver.findElement(By.xpath("//li[text()='New Delhi Railway Station, Delhi, India']")).click();
         
         driver.findElement(By.xpath("//label[@for='dest']")).click();
         WebElement data1 = driver.findElement(By.xpath("//input[@id='dest']"));
         data1.sendKeys("banglore");
        driver.findElement(By.xpath("//li[text()='Marathahalli, Bangalore, Karnataka, India']")).click();
        
        driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
  
        String month="January";
        String date="24";
        String year="2023";
        Thread.sleep(2000);
        
        for(;;)
        {
        	try
        	{
        		driver.findElement(By.xpath("//div[text()='"+month+"' and text()='"+year+"']")).click();
        		break;
        	}
        	
        	catch(Exception e)
        	{
        		driver.findElement(By.xpath("//div[@id='next']")).click();
        	}
        }
        
       	
        
       // driver.findElement(By.xpath("//div[text()='"+month+"' and text()='"+year+"']/../..//span[text()='"+date+"']")).click();
       		
       // driver.findElement(By.xpath("//div[@id='next']")).click();
        
        		  
        driver.findElement(By.xpath("//label[text()='return  date']")).click();
        
        Thread.sleep(2000);
      
        String month1="February";
        String date1="15";
        String year1="2023";
        
        for(;;)
        {
        	try {
        		
        	 driver.findElement(By.xpath("//div[text()='"+month1+"' and text()='"+year1+"']/parent::div/parent::div//span[text()='"+date1+"']")).click();
        	 break;
      // driver.findElement(By.xpath("//div[text()='February' and text()='2023']/parent::div/parent::div//span[text()='15']")).click();
      
        	}
        catch(Exception e)
        	{
        	driver.findElement(By.xpath("//div[@id='next']")).click();
        	}
        
        }
        
		
		driver.findElement(By.xpath("//div[text()='SEARCH']")).click();
		
		driver.findElement(By.xpath("(//button[.='STAY HERE'])[2]")).click();

	}
	}


