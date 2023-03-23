package practise_package_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccTable {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/homepage");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[contains(text(),'Rankings')])[1]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Team Rankings')])[3]")).click();
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]/span[2]"));
		List<WebElement> ratings = driver.findElements(By.xpath("//tbody/tr/td[5]"));
		
		for(int i=0;i<=teams.size();i++)
		{
			System.out.println(teams.get(i).getText()+"="+ratings.get(i).getText());
		}
		
		driver.close();
	}

}
