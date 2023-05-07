package Handlingframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingIframe {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		// 1st iframe 
		driver.switchTo().frame("packageListFrame"); // name or Id of frame
		driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']")).click();
		driver.switchTo().defaultContent(); // go back to main page
		
		// 2nd iframe 
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
		driver.switchTo().defaultContent();
		
		//3rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//a[text()='Help']")).click();
		driver.switchTo().defaultContent();
		
		
	}

}
