package mtr;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectAllAndDeselectAllInReverseOrder {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement mtrList=driver.findElement(By.id("mtr"));
		Select s=new Select(mtrList);
		
		List<WebElement> allOptions=s.getOptions();
		int count=allOptions.size();
		for(int i=0;i<count;i++)
		{
			s.selectByIndex(i);
			Thread.sleep(2000);
		}
		
		for(int i=count-1;i>=0;i--)
		{
			s.deselectByIndex(i);
			Thread.sleep(2000);
		}
		driver.close();
		
	}

}
