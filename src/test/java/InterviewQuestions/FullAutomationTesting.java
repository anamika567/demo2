package InterviewQuestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FullAutomationTesting {

	@Test
	public void m1() throws IOException, AWTException, Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		WebElement jobs = driver.findElement(By.linkText("Jobs"));
		Actions act=new Actions(driver);
		act.moveToElement(jobs).perform();
		WebElement itJobs = driver.findElement(By.linkText("IT jobs"));
		//act.moveToElement(itJobs).click().build().perform();
		act.click(itJobs).perform();
		WebElement connectWithUs = driver.findElement(By.linkText("Connect with us"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", connectWithUs);
//		int y = connectWithUs.getLocation().getY();
//		jse.executeScript("window.scrollBy(0,"+y+")", connectWithUs);
		jse.executeScript("window.scrollBy(0,10000);");
		
		WebElement naukriSS = driver.findElement(By.xpath("//div[@class='nI-gNb-social-links']"));
		File src = naukriSS.getScreenshotAs(OutputType.FILE);
		File trg=new File("./screenshot/naukri.png");
		FileUtils.copyFile(src, trg);
		
		driver.findElement(By.linkText("Register")).click();
		WebElement uploadResume = driver.findElement(By.xpath("//button[text()='Upload Resume']"));
		jse.executeScript("window.scrollBy(0,2000);");
		uploadResume.click();
		StringSelection path=new StringSelection("Desktop\\AnamikaSingh Resume.pdf");
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		driver.navigate().back();
		jse.executeScript("window.scrollBy(0,10000);");
		driver.findElement(By.xpath("//a[text()='Connect with us']/../a[2]/img[1]")).click();//fb
		driver.findElement(By.xpath("//a[text()='Connect with us']/../a[3]/img[1]")).click();//insta
		driver.findElement(By.xpath("//a[text()='Connect with us']/../a[4]/img[1]")).click();//twitter
		
		
	}

}
