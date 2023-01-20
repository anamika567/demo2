package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		int result=0;
		try
		{
	Driver driver =new Driver();
		
		// step 1: Register the database
			DriverManager.registerDriver(driver);
		
		// step 2: get connection for the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			
		// step 3: Issue create statement
			Statement state = con.createStatement();
			String query="delete from StudentInfo where Sname='Neha';";
			
		// step 4: Execute query
			
			result=state.executeUpdate(query);
			
	}		
	
	catch(Exception e)
	{
		
	}

	finally
	{
		if(result==1)
		{
			System.out.println("Data inserted successfully");
		}
		else
		{
			System.out.println("Data not inserted");
		}
		
		// close the connection
		con.close();


	}
	}
}
