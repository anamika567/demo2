package practise_package_assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class getalldropdownintoexcelsheet {
	int random;
	
	public void getRandom()
{
		Random r=new Random();
		int random = r.nextInt(50);
}
	
	public void readdata(int rownum,int cellnum,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./data/dropdown.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.createSheet("Sheet"+random);
		sh.createRow(rownum).createCell(cellnum).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/dropdown.xlsx");
		book.write(fos);
		
	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		getalldropdownintoexcelsheet gt=new getalldropdownintoexcelsheet();
		
		int i;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.orangehrm.com/contact-sales/");
		WebElement countryDropDown = driver.findElement(By.id("Form_getForm_Country"));
		Select s=new Select(countryDropDown);
		List<WebElement> dd = s.getOptions();
		for(i=0;i<dd.size();i++)
		{
			String text = dd.get(i).getText();
			System.out.println(text);

			gt.readdata(i, 0, text);
			
		}

	}

}
