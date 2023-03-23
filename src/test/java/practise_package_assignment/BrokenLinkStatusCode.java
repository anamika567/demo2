package practise_package_assignment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkStatusCode {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		List<WebElement> linkList = driver.findElements(By.xpath("//a"));
		List<String> brokenLink=new ArrayList<String>();
		for(int i=0;i<linkList.size();i++)
		{
			String link=linkList.get(i).getAttribute("href");
			URL url;
			int statusCode=0;
			try {
				url=new URL(link);
				URLConnection urlConnec=url.openConnection();
				HttpURLConnection HttpURLConnection=(HttpURLConnection)urlConnec;
				statusCode=HttpURLConnection.getResponseCode();
				if(statusCode>=400)
				{
					brokenLink.add(link+"-->"+statusCode);
				}
			}
			catch(Exception e) {
				brokenLink.add(link);
				continue;
			}
		}
		System.out.println(brokenLink);

	}

}
