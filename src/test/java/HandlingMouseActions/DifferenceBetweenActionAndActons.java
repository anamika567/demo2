package HandlingMouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class DifferenceBetweenActionAndActons {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/");
		
		WebElement features = driver.findElement(By.xpath("//a[text()='Desktops']"));

		// Actions class
		Actions act=new Actions(driver);
		//act.moveToElement(features).perform();
		
		//Action interface
		Action action = act.moveToElement(features).build();
		action.perform();
		
	}

}
