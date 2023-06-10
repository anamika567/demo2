package InterviewQuestions;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetNew {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		String fromcity = "Beng";
		WebElement from=driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input"));
		from.sendKeys(fromcity);
		
		Thread.sleep(2000);
		String tocity = "DEL";
		WebElement to=driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input"));
		to.clear();
		to.sendKeys(tocity);
		Thread.sleep(2000);

		Date d=new Date();
		System.out.println(d);
		String []dd=d.toString().split(" ");
		String datee=dd[2];
		int da=Integer.parseInt(datee);
		int yes=da+9;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-day-"+yes+"']")).click();
				
		driver.findElement(By.xpath("//div[text()='Search Flight']//..//..")).click();

	}
}
