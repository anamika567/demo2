package CaptureScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		// Full page screenshot
//		
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshot/nopcommerce.png");
//		FileUtils.copyFile(src, dest);
//		
		// screenshot of portion/section of the page
		
//		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//		File src = section.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenshot/newnopcommerce.png");
//		FileUtils.copyFile(src, dest);
//		
		// screenshot of particular element
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = logo.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/nnopcommerce.png");
		FileUtils.copyFile(src, dest);
		
		driver.close();
	}

}
