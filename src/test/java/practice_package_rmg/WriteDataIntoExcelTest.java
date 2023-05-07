package practice_package_rmg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		
		Workbook wb=WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Organisation");
		
		Row ro = sh.createRow(2);
		
		Cell cel=ro.createCell(0);
		
		cel.setCellValue("Dream11");
		
		FileOutputStream fo=new FileOutputStream("./src/test/resources/TestData45.xlsx");
		
		wb.write(fo);
		

	}

}
