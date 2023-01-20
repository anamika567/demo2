package com.insurance.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility{
	/**
	 * This method is used to read the data from excel.
	 * @author Anamika
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName,int RowNo,int ColumnNo) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row ro=sh.getRow(RowNo);
		Cell cel=ro.getCell(ColumnNo);
		String value=cel.getStringCellValue();
		return value;

	}
	

	
	/**
	 * This method is to write data into excel file.
	 * @author Anamika
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @param data
	 * @throws Throwable
	 */
	
	
	public void writeDataToExcel(String SheetName,int RowNo,int ColumnNo,String data) throws Throwable 
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row ro=sh.getRow(RowNo);
		Cell cel=ro.getCell(ColumnNo);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);

	}
	/**
	 * This method is used to get last row count.
	 * @author Anamika
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		return count;
		
	}
	/**
	 * This method is used to get the list by using map.
	 * @param SheetName
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Throwable
	 */
	
	public Map<String, String> getList(String SheetName,int keyCell,int valueCell) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		Map<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(keyCell).getStringCellValue();
			String value=sh.getRow(i).getCell(valueCell).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * This method is used to read multiple data from excel by using dataProvider.
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum()+1;
		int lastCell=sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
	
	
	/*
	public ArrayList<String> getList(String SheetName,int keyCell,int valueCell) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(SheetName);
		int count=sh.getLastRowNum();
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<count;i++)
		{
		list.add(sh.getRow(i).getCell(valueCell).getStringCellValue());
		}
		
		
//		list.add("client_id");
//		list.add("month");
//		list.add("amount");
//		list.add("due");
//		list.add("fine");
//		
		//for(int i=0;i<count;i++)
		//{
		//	String value=sh.getRow(i).getCell(1).getStringCellValue();
		//	driver.findElement(By.name(list.get(i))).sendKeys(value);
			
		//}
	
		return list;
	}
*/
}

