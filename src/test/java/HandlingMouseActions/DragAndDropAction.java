package HandlingMouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement field1 = driver.findElement(By.xpath("//ul[@id='gallery']//li[1]"));
		WebElement field2 = driver.findElement(By.xpath("//ul[@id='gallery']//li[2]"));
		
		WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(field1, trash).perform();
		act.dragAndDrop(field2, trash).perform();
		

	}

}
