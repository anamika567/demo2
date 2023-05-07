package practice_package_rmg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fi=new FileInputStream("./src/test/resources/TestData45.xlsx");
		
		Workbook wb=WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Organisation");
		
		String OrgName = sh.getRow(1).getCell(0).getStringCellValue();
		
		System.out.println(OrgName);
		

	}

}
