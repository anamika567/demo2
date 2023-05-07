package practise_package_assignment;

import java.awt.Desktop.Action;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip {
	
	public static void main(String[] args)  {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
	
		/*
		// Onewaytrip
		
		String fromcity = "Bengaluru";
		WebElement from = driver.findElement(By.id("fromCity"));
		from.sendKeys(fromcity);
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		
		
		String tocity = "Mangalore";
		WebElement to = driver.findElement(By.id("toCity"));
		to.sendKeys(tocity);
		driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
		
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();

		String tday="Sat";
		String tmonth="Feb";
		String tdate="04";
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
		
		*/
		
		
		// Roundtrip
		
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		
		String fromcity = "Bengaluru";
		WebElement from = driver.findElement(By.id("fromCity"));
		from.sendKeys(fromcity);
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		
		
		String tocity = "Mangalore";
		WebElement to = driver.findElement(By.id("toCity"));
		to.sendKeys(tocity);
		driver.findElement(By.xpath("//p[.='Mangalore, India']")).click();
		
		String tday="Fri";
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
		
		String rday="Wed";
		String rmonth="May";
		String rdate="10";
		String ryear="2023";
		String returndate=rday+" "+rmonth+" "+rdate+" "+ryear;
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label='"+returndate+"']")).click();
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
