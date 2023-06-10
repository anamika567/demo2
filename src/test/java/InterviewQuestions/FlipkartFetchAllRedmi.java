package InterviewQuestions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartFetchAllRedmi {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("Redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
      List<WebElement> allRedmi = driver.findElements(By.xpath("//div[@class='_2kHMtA']/descendant::div[@class='_4rR01T']"));
	 int n=allRedmi.size();
	 System.out.println(n);
      for(int i=0;i<n;i++)
      {
    	  String text = allRedmi.get(i).getText();
    	  System.out.println(text);
    	  
    	  FileInputStream fis=new FileInputStream("./data/Redmiphone.xlsx");
    	  Workbook wb=WorkbookFactory.create(fis);
    	  Sheet sh=wb.getSheet("Sheet1");
    	  sh.createRow(i).createCell(0).setCellValue(text);
    	  FileOutputStream fos=new FileOutputStream("./data/Redmiphone.xlsx");
    	  wb.write(fos);
      }
      driver.close();
	}

}
