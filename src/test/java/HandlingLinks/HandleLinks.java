package HandlingLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleLinks {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
		driver.findElement(By.xpath("//input[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']")).click();
		//driver.findElement(By.linkText("Today's Deals")).click();
		//driver.findElement(By.partialLinkText("Today's D")).click();
		
		// capture all links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//System.out.println(allLinks.size());
		
		// for loop
//		for(int i=0;i<allLinks.size();i++)
//		{
//			System.out.println(allLinks.get(i).getText());
//			System.out.println(allLinks.get(i).getAttribute("href"));
//		}

       // foreach loop
		for(WebElement links:allLinks)
		{
			System.out.println(links.getText());
			System.out.println(links.getAttribute("href"));
		}
		
	}

}
