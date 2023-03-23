package Mock;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Washingmachine {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/Voltas-Beko-Automatic-WTT90UDX-BKGR4KPTD/dp/B0BSNNT9JY/ref=sr_1_1_sspa?keywords=washing%2Bmachine%2B10kg&qid=1679309473&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&th=1");
		
	    List<WebElement> heading = driver.findElements(By.xpath("//table[@id='productDetails_techSpec_section_1']/tbody/tr/th"));
		List<WebElement> details = driver.findElements(By.xpath("//table[@id='productDetails_techSpec_section_1']/tbody/tr/td"));
	    for(int i=0;i<heading.size();i++)
	    {
			System.out.println(heading.get(i).getText()+"="+details.get(i).getText());

	    }
	
	driver.close();
	}

}
