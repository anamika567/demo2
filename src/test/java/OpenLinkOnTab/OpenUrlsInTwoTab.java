package OpenLinkOnTab;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

public class OpenUrlsInTwoTab {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		//  add selenium 4 version then it works bcz introduced in selenium 4
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.opencart.com/");
	}

}
