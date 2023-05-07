package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetNew {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/parent::div/descendant::input")).sendKeys("DEL");
		
		driver.findElement(By.xpath("//div[text()='To']/parent::div/descendant::input")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
		
		Thread.sleep(3000);
		
		JavascriptExecutor j= (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("//div[@data-testid='undefined-month-April-2023']/descendant::div[text()='25']")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		
		driver.findElement(By.xpath("//div[text()='Done']/..")).click();
		driver.findElement(By.xpath("//div[text()='Family & Friends']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']/descendant::div[@style='margin-right: 6px;']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		driver.findElement(By.xpath("//div[text()='I have read and agreed to the ']/ancestor::div[@class='css-1dbjc4n r-13awgt0 r-18u37iz']/descendant::div[@class='css-1dbjc4n r-zso239']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Continue']/parent::div")).click();

	}

}
