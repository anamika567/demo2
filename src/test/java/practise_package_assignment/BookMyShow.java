package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyShow {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://in.bookmyshow.com/explore/home/mumbai");
		driver.findElement(By.xpath("//img[@alt='Adipurush']")).click();
		driver.findElement(By.xpath("//div[@class='sc-qswwm9-8 jayiEd']/div/button/div/span[text()='Book tickets']")).click();
		driver.findElement(By.xpath("//li[1]/section[@class='sc-vhz3gb-2 ceXPQZ']/div/span[text()='2D']")).click();
		
	}

}
