package HandlingDropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckDropdownSorted {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://twoplugs.com/");
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement drpElement = driver.findElement(By.name("category_id"));
		
		Select drpselect=new Select(drpElement);
		
		List<WebElement> options = drpselect.getOptions();
		
		ArrayList originalList=new ArrayList();
		ArrayList tempList=new ArrayList();
		
		for(WebElement option:options)
		{
			originalList.add(option.getText());
			tempList.add(option.getText());

		}
		System.out.println("original list" + originalList);
		System.out.println("temporary list" + tempList);
		
		Collections.sort(tempList);
		
		System.out.println("original list" + originalList);
		System.out.println("temporary list" + tempList);
		
		if(originalList.equals(tempList))
		{
			System.out.println("dropdown sorted");
		}
		else
		{
			System.out.println("dropdown unsorted");
		}
		
		driver.close();
	}

}
