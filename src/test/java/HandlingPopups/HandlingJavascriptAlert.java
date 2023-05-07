package HandlingPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJavascriptAlert {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		// Alert window with OK button
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		driver.switchTo().alert().accept();
//		
		// Alert window with OK Cancel button
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		driver.switchTo().alert().accept(); // close by ok button
//		driver.switchTo().alert().dismiss(); // close by cancel button
//		
		// Alert box with input box ,capture text from alert box
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alertWindow = driver.switchTo().alert();
		System.out.println("The messsge on alert"+ alertWindow.getText());
		alertWindow.sendKeys("Welcome");
		alertWindow.accept();
		
		
		
	}

}
