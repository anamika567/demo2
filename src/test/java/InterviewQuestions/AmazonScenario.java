package InterviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonScenario {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/deals?ref_=nav_cs_gb&deals-widget=%257B%2522version%2522%253A1%252C%2522viewIndex%2522%253A0%252C%2522presetId%2522%253A%252246D1B0D1F5B0A9C0FA93E8A7CDA9F06D%2522%252C%2522sorting%2522%253A%2522FEATURED%2522%257D");
		
		List<WebElement> two = driver.findElements(By.xpath("//div[@class='DealContent-module__truncate_sWbxETx42ZPStTc9jwySW']"));
		int s=two.size();
		System.out.println(s);
		for(int i=0;i<2;i++)
		{
			System.out.println(two.get(i).getText());
		}
	}

}
