package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonScroll {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[text()='Help']"));
		int y = element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")", element);
		element.click();
		
	
		

	}

}
