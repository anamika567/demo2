package mtr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOptionsInAlphabeticalOrder {

	public static void main(String[] args) {

		ArrayList<String> al=new ArrayList<String>();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement mtrList=driver.findElement(By.id("mtr"));
		Select s=new Select(mtrList);
		List<WebElement> allOptions = s.getOptions();
		for(int i=0;i<allOptions.size();i++)
		{
			String text=allOptions.get(i).getText();
			al.add(text);
		}
		
		Collections.sort(al);
		
		for(String options:al)
		{
			System.out.println(options);
		}
		
		System.out.println("----------Reverse order-----------");
		
		Collections.reverse(al);
		for(String options:al)
		{
			System.out.println(options);
		}
		
		
		driver.close();
	}

}
