package mtr;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllSelectedOption {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("file:///C:/Users/hp/Desktop/mtrdemo.html");
		
		WebElement cpList=driver.findElement(By.id("cp"));
		Select s=new Select(cpList);
		s.selectByIndex(0);
		s.selectByIndex(1);
		s.selectByIndex(2);
		s.selectByIndex(3);
		
	    List<WebElement> allOptions=s.getAllSelectedOptions();
	    int count=allOptions.size();
	    for(int i=0;i<count;i++)
	    {
	    	String text=allOptions.get(i).getText();
	    	System.out.println(text);
	    }
	    driver.close();
	    
	}

}
