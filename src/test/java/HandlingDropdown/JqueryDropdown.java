package HandlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropdown {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		//selectChoiceValue(driver, "choice 1");
		//selectChoiceValue(driver, "choice 2","choice 2 3","choice 6","choice 6 2");
		selectChoiceValue(driver, "all");

		
	}
	
	public static void selectChoiceValue(WebDriver driver, String... value)
	{
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement item:choiceList)
			{
				String text = item.getText();
				
				for(String val:value)
				{
					if(text.equals(val))
					{
						item.click();
						break;
					}
				}
			}
		}
		
		else 
		{
			try 
			{
				for(WebElement item:choiceList)
				{
					item.click();
				}
			} catch (Exception e) {
			}
			
		}
		
	}

}
