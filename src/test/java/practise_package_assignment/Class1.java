package practise_package_assignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

public class Class1 {

	public static void main(String[] args) throws MalformedURLException {
		
		Reporter.log("Test1-class1 "+Thread.currentThread().getId(),true);
		URL url=new URL("http://192.168.0.191:4445/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		WebDriver driver=new RemoteWebDriver(url, cap);
		driver.manage().window().maximize();
		driver.get("https://rmgtestingserver/domain/");
		

	}

}
