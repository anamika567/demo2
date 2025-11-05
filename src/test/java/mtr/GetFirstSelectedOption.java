package mtr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetFirstSelectedOption {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement cpList = driver.findElement(By.id("cp"));
		Select s=new Select(cpList);
		s.selectByIndex(0);
		s.selectByIndex(1);
		s.selectByIndex(2);
		
		WebElement fsOption=s.getFirstSelectedOption();
		String text=fsOption.getText();
		System.out.println(text);
		
		driver.close();
		
	}

}
