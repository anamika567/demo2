package HandlingSlider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		
		WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']/span[1]"));
		
	    System.out.println("Location of min slider:"+min_slider.getLocation()); // (59, 250)
	    System.out.println("height and width of element:"+min_slider.getSize()); // (21, 21)
	    
	    Actions act=new Actions(driver);
	    act.dragAndDropBy(min_slider, 100, 0).perform();
	    
	    System.out.println("Location of min slider:"+min_slider.getLocation()); // (161, 250)
	    System.out.println("height and width of element:"+min_slider.getSize()); // (21, 21)


		WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']/span[2]"));
		act.dragAndDropBy(max_slider, -100, 0).perform();
		
		

		
	}

}
