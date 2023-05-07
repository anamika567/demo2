package practise_package_assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.reactivex.rxjava3.functions.Action;

public class DemoAutomation {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Register.html");
		
		// text
		driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("pawan");
		driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys("kumar");
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pawan@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("9456423210");
		
		// radio button
		System.out.println(driver.findElement(By.xpath("//input[@value='Male']")).isSelected());
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		//checkbox
		System.out.println(driver.findElement(By.id("checkbox1")).isSelected());
		driver.findElement(By.id("checkbox1")).click();
		
		//mouse hover
		driver.findElement(By.id("msdd")).click();
		WebElement language = driver.findElement(By.linkText("English"));
		Actions a=new Actions(driver);
		a.moveToElement(language).click().perform();
		
		//drop down
		WebElement skill = driver.findElement(By.id("Skills"));
		Select sel=new Select(skill);
		sel.selectByValue("Java");
		System.out.println(sel.getOptions().size());
		
		WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
		Select se=new Select(country);
		se.selectByVisibleText("Select Country");
		System.out.println(se.getOptions().size());
		
		WebElement select_country = driver.findElement(By.xpath("//select[@id='country']"));
        Select sc=new Select(select_country);
        sc.selectByValue("India");
        System.out.println(sc.getOptions().size());
		
       WebElement year = driver.findElement(By.id("yearbox"));
       Select y=new Select(year);
       y.selectByValue("1995");
       
       WebElement month = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
       Select m=new Select(month);
       m.selectByValue("June");
       
       WebElement day = driver.findElement(By.id("daybox"));
       Select d=new Select(day);
       d.selectByValue("17");
       
       driver.findElement(By.id("firstpassword")).sendKeys("abc123");
       driver.findElement(By.id("secondpassword")).sendKeys("abc12");
       //driver.findElement(By.id("submitbtn")).click();
       
		driver.findElement(By.id("Button1")).click();
		
		
	}

}
