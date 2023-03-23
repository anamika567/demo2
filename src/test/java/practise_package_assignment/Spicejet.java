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
		
		String tday="Fri";
		String tdate="17";
		String tmonth="March ";
		String tyear="2023";
		String traveldate=tday+" "+tdate+" "+tmonth+" "+tyear;
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()='"+tmonth+"' and text()='"+tyear+"']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
			}
		}
		
		
			
	}

}
