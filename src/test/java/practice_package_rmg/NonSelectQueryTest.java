package practice_package_rmg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
	try {
         Driver driver =new Driver();
		
		// step 1: Register the database
			DriverManager.registerDriver(driver);
		
		// step 2: get connection for the database
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		// step 3: Issue create statement
			Statement state = con.createStatement();
			String query="insert into project values('TY_Project_008','AnamikaSingh','21/12/2022','Life_Insurance_Management','created',3)";
			
			//step 4: Update query
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