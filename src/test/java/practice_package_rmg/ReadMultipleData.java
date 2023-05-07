package practice_package_rmg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {

	public static void main(String[] args) throws Throwable, IOException {
		
FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		
		Workbook wb=WorkbookFactory.create(fi);
		
		int rowCount=wb.getSheet("Company").getLastRowNum();
		int cellCount=wb.getSheet("Company").getRow(0).getLastCellNum();
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String data=wb.getSheet("Company").getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+"\t");
		    
			}
			System.out.println();
		}


	}

}
