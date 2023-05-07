package practise_package_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

public class SearchYourNameOnGoogle {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Anamika");
		List<WebElement> allSug = driver.findElements(By.xpath("//span[contains(text(),'Anamika')]"));
		int count=allSug.size();  
		System.out.println(count);
		for(int i=0;i<count;i++)
		{
			String text = allSug.get(i).getText();
			System.out.println(text);
			
		}
		
		driver.close();
	}

}
