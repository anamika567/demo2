package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewQustion {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Anamika");
		ArrayList<String> list=new ArrayList<String>();
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='erkvQe']/descendant::span[contains(text(),'Anamika')]"));
		WebElement third = driver.findElement(By.xpath("(//div[@class='erkvQe']/descendant::span[contains(text(),'Anamika')])[3]"));
		System.out.println(third);
		
		for(int i=0;i<name.size();i++)
	    {
	    	String text = name.get(i).getText();
	    	System.out.println(text);
	    }
	Collections.sort(list);
	for(String ob:list)
	{
		System.out.println(ob);
	}
	
	}

}
