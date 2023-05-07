package Handlingframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerFrame2 {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		driver.switchTo().frame("iframeResult"); // switch to outer iframe
		driver.switchTo().frame(0); // switch to inner frame
		
		System.out.println("text inside:"+ driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame(); // go to parent frame
		String text = driver.findElement(By.xpath("//p[contains(text(),'You can use the height and widt')]")).getText();
		System.out.println(text);
		
	
	}

}
