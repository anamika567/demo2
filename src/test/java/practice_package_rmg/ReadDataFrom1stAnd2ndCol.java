package practice_package_rmg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFrom1stAnd2ndCol {

	public static void main(String[] args) throws Throwable, IOException {
		
       FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		
		Workbook wb=WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Company");
		
		int count = sh.getLastRowNum();
		
		for(int i=1;i<count;i++)
		{
			Row row = sh.getRow(i);
			
			String data1 = row.getCell(0).getStringCellValue();
			String data2 = row.getCell(1).getStringCellValue();
			System.out.println(data1 +"\t"+data2);

			
			
			
		}
		
		


	}

}
