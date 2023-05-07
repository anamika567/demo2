package HandlingLinks;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrokenLinks {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		int brokenLink=0;
		for(WebElement element:links)
		{
			String url=element.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("url is empty");
				continue;
			}
			
			URL link=new URL(url);
			
			try {
				HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
				httpconn.connect();
				
				if(httpconn.getResponseCode()>=400)
				{
					System.out.println(httpconn.getResponseCode() +url +" is"+" broken link");
					brokenLink++;
				}
				else
				{
					System.out.println(httpconn.getResponseCode() +url +" is"+" valid link");

				}
				
			} catch (Exception e) {
			}
				
		}
		
		System.out.println("Number of broken link:" +brokenLink);
		driver.quit();
		
	}

}
