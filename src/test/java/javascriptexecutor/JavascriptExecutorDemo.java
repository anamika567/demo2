package javascriptexecutor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.twoplugs.com/");

		driver.manage().window().maximize();
		
		// flashing
		WebElement joinFree = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[2]/a"));

		//JavaScriptUtil.flash(joinFree, driver);
	
		// drawing border and screenshot
		
//		JavaScriptUtil.drawBorder(joinFree, driver);
//		
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File trg=new File("./screenshot/twoplug.png");
//		FileUtils.copyFile(src, trg);
//		
		// capture title of the page
		String title = JavaScriptUtil.getTitleByJS(driver);
		System.out.println(title);
		
//		// click on element
//		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a/span"));
//		JavaScriptUtil.clickElementByJS(loginBtn, driver);
//		
//		// generate alert
//		JavaScriptUtil.generateAlert(driver, "you clicked on login button...");
//		
//		// refresh browser
//
//		JavaScriptUtil.refreshBrowserByJS(driver);
		
//		// scroll down till we find element
//		WebElement image = driver.findElement(By.xpath("//*[@id=\"rslides3_s0\"]/div[1]/img"));
//		JavaScriptUtil.scrollIntoview(image, driver);
//	
	// scroll down till end
		JavaScriptUtil.scrollPageDown(driver);
	
	
	}
 
}
