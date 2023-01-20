package practise_package_assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Icc {

	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryname = "India";
		WebElement points=driver.findElement(By.xpath("//span[.='"+countryname+"']/../following-sibling::td[2]"));
		System.out.println(points.getText());
		//List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2] | //tbody/tr/td[4]"));
	/*	List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr//td[2]/span[2]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr//td[4]"));
		
		for(int i=0;i<teams.size();i++)
		{
			System.out.println(teams.get(i).getText()+"="+points.get(i).getText());
		}
*/
	}

}
