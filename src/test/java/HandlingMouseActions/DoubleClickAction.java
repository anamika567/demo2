package HandlingMouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.id("field1"));
		field1.clear();
		field1.sendKeys("welcome to selenium");
		
		WebElement copybutton = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions act=new Actions(driver);
		act.doubleClick(copybutton).perform();
		

		
		
	}

}
