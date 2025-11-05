package mtr;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOptionsWithoutDuplicates {

	public static void main(String[] args) {

		HashSet<String> set=new HashSet<String>();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement mtrList=driver.findElement(By.id("mtr"));
		Select s=new Select(mtrList);
		List<WebElement> allOptions = s.getOptions();
		int count=allOptions.size();
		for(int i=0;i<count;i++)
		{
			String text=allOptions.get(i).getText();
			set.add(text);
		}
		
		for(String options:set)
		{
			System.out.println(options);
		}
		
		driver.close();
	}

}
