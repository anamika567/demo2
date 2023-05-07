package SizeAndLoaction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeAndLocation {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement logo = driver.findElement(By.xpath("//img[@src='/web/images/ohrm_branding.png?1672659722816']"));
		
		// location -method1
		System.out.println("Location :"+logo.getLocation());
		System.out.println("Location of x :"+logo.getLocation().getX());
		System.out.println("Location of y :"+logo.getLocation().getY());

		// loaction -method2
		System.out.println("Location of x :"+logo.getRect().getX());
		System.out.println("Location of y :"+logo.getRect().getY());
		
		// size -method1
		System.out.println("size "+logo.getSize());
		System.out.println("size of width:"+logo.getSize().getWidth());
		System.out.println("size of height:"+logo.getSize().getHeight());


		// size -method2
		System.out.println(logo.getRect().getDimension().getWidth());
		System.out.println(logo.getRect().getDimension().getHeight());

		
		
	}

}
