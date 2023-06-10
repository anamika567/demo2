package practise_package_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip_Bus_Test {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		WebElement e = driver.findElement(By.xpath("//img[@src='//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/mmtLogoWhite.png']"));
		Actions act= new Actions(driver);
		act.doubleClick(e).perform();
		driver.findElement(By.xpath("//a[@href='https://www.makemytrip.com/bus-tickets/']")).click();
		
		 driver.findElement(By.id("fromCity")).click();
		 driver.findElement(By.xpath("//span[.='Bangalore, Karnataka']")).click();
		 
		// driver.findElement(By.id("toCity")).click();
		 driver.findElement(By.xpath("//span[.='Hyderabad, Telangana']")).click();
		 
		 driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();
		 
		 driver.findElement(By.xpath("//button[@class='primaryBtn font24 latoBold widgetSearchBtn']")).click();
		 
		 
		  List<WebElement> busName = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
		  
		  int count=busName.size();
		  System.out.println(count);
		  for(WebElement i:busName)
		  {
		  	System.out.println(i.getText());
		  }
		  	driver.close();
	}

}
