package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookDropdown {

	public static void selectValueFormDropdown(WebElement element,String value) {
		
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}


	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
	//	1. 
		
//		Select s1=new Select(day);
//		s1.selectByVisibleText("17");
//		
//		Select s2=new Select(month);
//		s2.selectByVisibleText("May");
//		
//		Select s3=new Select(year);
//		s3.selectByVisibleText("1995");
//		
	//	2.
//		selectValueFormDropdown(day, "18");
//		selectValueFormDropdown(month, "May");
//		selectValueFormDropdown(year, "1996");
//		
	//   3.
		String dob="24-May-1995";
		String dobArr[]=dob.split("-");
		
		selectValueFormDropdown(day, dobArr[0]);
		selectValueFormDropdown(month, dobArr[1]);
		selectValueFormDropdown(year, dobArr[2]);
		
		
		
		
		
	}
	
}
