package practise_package_assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookMyshowWriteInDiffExcelSheet {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
		driver.findElement(By.xpath("//img[@alt='Kabzaa']")).click();
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		driver.findElement(By.xpath("(//span[.='2D'])[1]")).click();
		driver.findElement(By.id("wzrk-cancel")).click();
		
		List<WebElement> element = driver.findElements(By.xpath("//a[@class='__venue-name']"));
		int n = element.size();
		System.out.println(n);
		
		Random ran=new Random();
		int random=ran.nextInt(50);
		FileInputStream fis=new FileInputStream("./data/values.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		int i;
		for(i=0;i<element.size();i++)
		{
			
			String text=element.get(i).getText();
			System.out.println(text);
			Sheet sh = wb.createSheet("Sheet"+random);

			sh.createRow(i).createCell(0).setCellValue(text);

			FileOutputStream fos=new FileOutputStream("./data/values.xlsx");
			wb.write(fos);
			
			
		}
		
		
        driver.close();
		

	}

}
