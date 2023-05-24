package practise_package_assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookPrintDropdownOption {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		Select sel1=new Select(day);


		
		System.out.println(sel1.isMultiple());
		
		List<WebElement> listDays = sel1.getOptions();
		System.out.println(listDays.size());
		 int TotalDays = listDays.size()-1;
		 System.out.println(TotalDays);
		 
		 for(int i=0;i<listDays.size();i++)
		 {
			String value = listDays.get(i).getText();
			System.out.println(value);
			 
		 }
		 
	}

}
