package practise_package_assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMy {

		public static void main(String[] args) throws Throwable {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			
			Actions act=new Actions(driver);
			Thread.sleep(2000);

			act.moveByOffset(10, 10).click().perform();
			Thread.sleep(2000);

			act.moveByOffset(10, 10).click().perform();

			
			//WebElement e = driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
			//act.moveToElement(e).click().perform();
			
			String tday="Sat";
			String tmonth="Feb";
			String tdate="04";
			String tyear="2023";
			String traveldate=tday+" "+tmonth+" "+tdate+" "+tyear;
			driver.findElement(By.xpath("//div[@aria-label='"+traveldate+"']")).click();
			
			driver.findElement(By.xpath("//a[.='Search']")).click();
			
			
					}		

	}
