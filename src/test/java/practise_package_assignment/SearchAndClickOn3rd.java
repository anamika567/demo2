package practise_package_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchAndClickOn3rd {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		int count=list.size();
		for(int i=0;i<count;i++)
		{
			String text = list.get(i).getText();
			System.out.println(text);
		}
		
		list.get(3).click();
	}

}
