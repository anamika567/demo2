package Mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WashingmachinePrice {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/s?k=washing+machine&i=kitchen&crid=2IF5Z3SL5M2VS&sprefix=washing+machine%2Ckitchen%2C237&ref=nb_sb_noss_1");
		
		//ArrayList<String> list=new ArrayList<String>();
		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	
//		for(int i=0;i<price.size();i++)
//		{
//			String text = price.get(i).getText();
//			list.add(text);
//				
//		}
//		
//		Collections.sort(list);
//		for(String o:list)
//		{
//			
//			System.out.println(o);
//		}
		TreeSet<String> set=new TreeSet<String>();
		for(WebElement p:price)
		{
			String pp = p.getText();
			set.add(pp);
		}
		System.out.println(set);
		
	
	}

}
