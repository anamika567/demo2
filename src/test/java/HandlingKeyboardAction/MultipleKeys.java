package HandlingKeyboardAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleKeys {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://text-compare.com/");
		
		WebElement input1 = driver.findElement(By.id("inputText1"));
		WebElement input2 = driver.findElement(By.id("inputText2"));
		
		input1.sendKeys("hello how are you?");
		
		Actions act=new Actions(driver);
		
		// CTRL+A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		// CTRL+C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//TAB - shift to input2 box
		act.sendKeys(Keys.TAB);
		act.perform();
		
		// CTRL+V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		// compare text
		
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
			System.out.println("text copied");
		else
			System.out.println("text not copied");
		
		
		
	}

}
