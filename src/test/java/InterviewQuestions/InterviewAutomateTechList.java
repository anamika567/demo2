package InterviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewAutomateTechList {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		List<WebElement> data = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
		
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i).getText());
		}
	}

}
