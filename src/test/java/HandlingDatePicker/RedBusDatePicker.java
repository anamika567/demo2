package HandlingDatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusDatePicker {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:www.redbus.in/");
		
		String year="2023";
		String month="Oct";
		String date="24";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		while(true)
		{
			String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
		    String arr[]=monthYear.split(" ");
		    String mon=arr[0];
		    String yr=arr[1];
		    
		    if(mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
		    	break;
		    else
		    	driver.findElement(By.xpath("//button[text()='>']")).click(); 
		}
		
		// Date selection
		
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		
		for(WebElement ele:allDates)
		{
			String dt = ele.getText();
			
			if(dt.equals(date))
			{
				ele.click();
				break;
			}
		}
	}

}
