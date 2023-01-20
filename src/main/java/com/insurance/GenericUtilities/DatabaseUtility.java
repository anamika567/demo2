package com.insurance.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con=null;
	
	public void connectToDB(String dataBaseName) throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURL+dataBaseName, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);	
		
	}
	
	public String executeQueryAndgetData(String query,int columnIndex,String expData) throws Throwable
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columnIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
				
			}
		}
		
		if(flag)
		{
			System.out.println(expData+"project is created");
			return expData;
			
		}
		else
		{
			System.out.println("project not created");
			return "";
		}
	}
	public void closeDB() throws Throwable
	{
		con.close();
	}
}
