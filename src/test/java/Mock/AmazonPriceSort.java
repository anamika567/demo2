package Mock;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPriceSort {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/s?k=iphone+14&crid=2PV4S5FWW8S9S&sprefix=iphone%2Caps%2C1156&ref=nb_sb_ss_ts-doa-p_1_6");
		
		ArrayList<String> list=new ArrayList<String>();
		
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
		
		for(int i=0;i<price.size();i++)
		{
			String text = price.get(i).getText();
			list.add(text);
			
		}
		
		Collections.sort(list);
		
		for(String option:list)
		{
			System.out.println(option);
		}

	}

}
