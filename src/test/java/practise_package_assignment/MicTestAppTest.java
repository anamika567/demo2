package practise_package_assignment;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MicTestAppTest {

	public static void main(String[] args) throws Throwable {
		
	    ChromeOptions options = new ChromeOptions();
	    HashMap<String, Integer> contentSettings = new HashMap<String, Integer>();
	    HashMap<String,Object> profile = new HashMap<String, Object>();
	    HashMap<String,Object> prefs = new HashMap<String, Object>();
	    
	    contentSettings.put("media_stream", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
	      
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		driver.findElement(By.id("mic-launcher")).click();
		
		Thread.sleep(80000);
		
		
		 WebElement actData = driver.findElement(By.xpath("//li[@class='notice-done done_testingComplete']"));
		 String msg = actData.getText();
		 System.out.println(msg);
		 String exp="Testing was completed";
		
		if(msg.contains(exp))
		{
			System.out.println("Testing was completed successfully");
		}
		
		else
		{
			System.out.println("Testing was not completed.");
		}
		
		String freq = driver.findElement(By.xpath("//td[@id='mic-prop_tester_wt_rating']")).getText();
		System.out.println(freq);
		//driver.close();

	}

}
