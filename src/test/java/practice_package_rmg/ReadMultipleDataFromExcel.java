package practice_package_rmg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		
FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		
		Workbook wb=WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Company");
		
		int count=sh.getLastRowNum();
		for(int i=0;i<=count;i++)
		{
			String data=sh.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println(data);
		}

	}

}
