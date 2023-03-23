package practise_package_assignment;


import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccWomen {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/homepage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[contains(text(),'Rankings')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Player Rankings')])[1]")).click();
		String name = driver.findElement(By.xpath("//a[.='Beth Mooney']")).getText();
		System.out.println(name);
		
		// scroll
		JavascriptExecutor js=(JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	element.click();
	
	driver.close();
		
	}

}
