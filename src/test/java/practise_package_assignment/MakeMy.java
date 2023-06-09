package practise_package_assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMy {

		public static void main(String[] args) {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			
			Actions act=new Actions(driver);
			act.moveByOffset(10, 10).click().perform();
			
			driver.findElement(By.xpath("//span[text()='Departure']")).click();
					
			
			String tday="fri";
			String tmonth="May";
			String tdate="05";
			String tyear="2023";
			String traveldate=tday+" "+tmonth+" "+tdate+" "+tyear;
			
	
			for(;;)
			{
				try {
					driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
					break;
				}
				catch(Exception e) {
					driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				}
			}
			
			driver.findElement(By.xpath("//a[.='Search']")).click();
			driver.close();
			
					}		

	}
