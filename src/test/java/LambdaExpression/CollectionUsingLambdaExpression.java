package LambdaExpression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//1)Find Number of links
//2)print link text from all the links
//3)check how many links does not have href attribute(broken links)

public class CollectionUsingLambdaExpression {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demowebshop.tricentis.com/");
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are:"+alllinks.size());
		
	//  using foreach loop
		
//		for(WebElement link:alllinks)
//		{
//			System.out.println(link.getText());
//		}

	//  using lambda expression
		//alllinks.forEach(link->System.out.println(link.getText()));
		
  //   processing elements using stream->filter	
		//long workingLinks = alllinks.stream().filter(link->link.getAttribute("href")!=null).count();
		//System.out.println("working links are:"+workingLinks);
		driver.close();
		
		
		
	}

}

