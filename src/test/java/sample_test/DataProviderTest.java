package sample_test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.insurance.GenericUtilities.ExcelUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getData")
	public void readData(String from ,String to)
	{
		System.out.println(from+"--->"+to);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable {
		
		ExcelUtility elib=new ExcelUtility();
		Object[][] value=elib.readMultipleSetOfData("DataProvider");
		return value;
				
	}
	

}
