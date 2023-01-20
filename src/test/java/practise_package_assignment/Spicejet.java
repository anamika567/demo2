package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Spicejet {
	
	public static void main(String[] args) throws Throwable {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	Actions action=new Actions(driver);
	action.moveByOffset(10, 10).click().perform();

		String fromcity = "Bengaluru";
		WebElement from=driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input"));
		from.sendKeys(fromcity);
		
		String tocity = "Mangaluru";
		WebElement to=driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input"));
		to.clear();
		to.sendKeys(tocity);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
		
		String tday="Sat";
		String tmonth="Jan";
		String tdate="14";
		String tyear="2023";
		String traveldate=tday+" "+tdate+" "+tmonth+" "+tyear;
		
		driver.findElement(By.xpath("//div[@class = 'css-76zvg2 css-bfa6kz r-homxoj r-ubezar']")).sendKeys("traveldate");
		
		
		
	/*	*/		
	}

}
