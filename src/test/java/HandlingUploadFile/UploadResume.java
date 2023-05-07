package HandlingUploadFile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadResume {

	public static void main(String[] args) throws AWTException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.foundit.in/");
		
		driver.findElement(By.xpath("//div[@class='heroSection-buttonContainer_secondaryBtn__text']")).click();
		
		// Using sendKeys() --> we use sendkeys when @input type=file only otherwise we use robot class
		//driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\hp\\Desktop\\resume\\s16MyResume.docx");
		
		// Using Robot class
		
		// driver.findElement(By.xpath("//input[@id='file-upload']")).click(); //click will not work then use javascripExecutor
		WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button); // click on button
		
		/*
		 * 1)copy the path
		 * 2)Ctrl+v
		 * 3)enter
		 */
		
		Robot r=new Robot();
		r.delay(1000);
		
		// 1) put path to file in a clipboard
		StringSelection ss=new StringSelection("C:\\Users\\hp\\Desktop\\resume\\s16MyResume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		// 2) cntrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		// 3)enter
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}

}
