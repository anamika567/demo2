package mtr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllOptionsWithoutUsingLoop {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement mtrList=driver.findElement(By.id("mtr"));
		Select s=new Select(mtrList);
		WebElement allOptions = s.getWrappedElement();
		String text=allOptions.getText();
		System.out.println(text);
		
		driver.close();
		
		
		
	}

}
