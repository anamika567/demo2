package HandlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropdown {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg as_extra_pad']//span[@class='sa_tm_text']"));

		System.out.println(list.size());
		
		for(WebElement listItem:list)
		{
			if(listItem.getText().contains("webdriver"))
			{
			listItem.click();
			break;
			}
		}
		
	}

}
