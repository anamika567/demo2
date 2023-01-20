package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capture_live_population {

	public static void main(String[] args) throws InterruptedException {
		    WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.worldometers.info/world-population/");
			int count=0;
			while(count<=5)
			{
				String data=driver.findElement(By.xpath("//div[@class='maincounter-number']/child::span[@class='rts-counter']")).getText();
				//String data=driver.findElement(By.xpath("//div[text()='Today']/parent::div/descendant::span[@rel='births_today']")).getText();
				System.out.println(data);
				Thread.sleep(1000);
				count++;
			
			}
			
			driver.close();

	}

}
