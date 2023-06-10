package InterviewQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/"); // get() method will wait till page load.
		driver.get("https://www.amazon.in/");
		//driver.navigate().to("https://www.amazon.in/"); // navigate.to() method will not wait for page load
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	
	
	}

}
