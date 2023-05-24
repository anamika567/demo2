package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Spicejet {
	
	public static void main(String[] args) throws InterruptedException {
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
		
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,200)");
		
		//driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
		
		
		
		String tday="Tue,";
		String tdate="30";
		String tmonth="May ";
		String tyear="2023";
		String traveldate=tday+" "+tdate+" "+tmonth+" "+tyear;
		for(;;)
		{
			try {

			    driver.findElement(By.xpath("//div[text()='August ' and text()='2023']/ancestor::div[contains(@data-testid,'undefined-month')]/descendant::div[text()='30']")).click();
				

		       //driver.findElement(By.xpath("//div[text()='"+tmonth+"' and text()='"+tyear+"']/ancestor::div[contains(@data-testid,'undefined-month')]/descendant::div[text()='"+tdate+"']")).click();


				//driver.findElement(By.xpath("//div[text()='"+tday+"' and text()='"+tdate+"' and text()='"+tmonth+"' and text()='"+tyear+"']")).click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='svg-img']/descendant::*[local-name()='g' and @fill='none' and @fill-rule='evenodd' and contains(@transform,'translate')]")).click();
			}
		}
		
		
			
	}

}
