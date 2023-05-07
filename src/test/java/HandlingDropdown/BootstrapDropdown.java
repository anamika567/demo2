package HandlingDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hdfcbank.com/");
		driver.findElement(By.xpath("//div[@class='drp1']/div[@class='dropdown']")).click();
		
		//Product type
		List<WebElement> productType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println("no. of product" + productType.size());
		selectOptionFromDropdown(productType, "Accounts");
		
//		for(WebElement ptype:productType)
//		{
//			if(ptype.getText().equals("Accounts"))
//			{
//				ptype.click();
//				break;
//			}
//		}
		
		// Product
		driver.findElement(By.xpath("//div[@class='drp2']/div[@class='dropdown']")).click();
		List<WebElement> products = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']/li"));
		System.out.println("product" + products.size());
		selectOptionFromDropdown(products, "Salary Accounts");
		
//		for(WebElement product:products)
//		{
//			if(product.getText().equals("Salary Accounts"))
//			{
//				product.click();
//				break;
//			}
//		}
		
	}

	// generic method for dropdown
	public static void selectOptionFromDropdown(List<WebElement> options, String value)
	
	{
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
	
}
