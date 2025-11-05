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
		driver.findElement(By.name("q")).sendKeys("java");
		ArrayList<String> list=new ArrayList<String>();
		List<WebElement> name = driver.findElements(By.xpath("//span[contains(text(),'java')]"));
		int count=name.size();
		System.out.println(count);
		
		System.out.println("***********");
		System.out.println(name.get(count-8).getText());
		System.out.println("***********");
		
		for(int i=0;i<count;i++)
	    {
	    	String text = name.get(i).getText();
	    	System.out.println(text);
	    	list.add(text);
	    }
		
	System.out.println("-----------------------------");
	Collections.sort(list);
	for(String ob:list)
	{
		System.out.println(ob);
	}
	
	}

}
