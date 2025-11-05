package mtr;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOptions {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement mtrList = driver.findElement(By.id("mtr"));
		Select s=new Select(mtrList);
		
		// Using for loop
		List<WebElement> allOption = s.getOptions();
		int count=allOption.size();
		for(int i=0;i<count;i++)
		{
			String text=allOption.get(i).getText();
			System.out.println(text);
		}
		
		// Using foreach loop
//		for(WebElement options:allOption)
//		{
//			String text=options.getText();
//			System.out.println(text);
//		}
		driver.close();
	}

}
