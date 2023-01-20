package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRmg {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();	
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("insurance2");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Anam");
		Thread.sleep(4000);
		
		WebElement dp = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s=new Select(dp);
		s.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Connection con=null;
		int result=0;
       try {
		 Driver driver1 =new Driver();
			
			// step 1: Register the database
				DriverManager.registerDriver(driver1);
			
			// step 2: get connection for the database
				con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			
			// step 3: Issue create statement
				Statement state = con.createStatement();
				String query="select * from project;";
				ResultSet result1 = state.executeQuery(query);
				boolean flag=false;
				while(result1.next())
				{
					String actualProject=result1.getString(4);
					System.out.println(actualProject);
					if(actualProject.equals("insurance2"))
					{
						flag=true;
						break;
						
					}
				}
				if(flag)
				{
					System.out.println("project is created");
				}
				else
				{
					System.out.println("project is not created");
				}
       }
			catch(Exception e)
			{
				e.printStackTrace();
			}
 
			finally
			{
				con.close();
				System.out.println("database is closed");
			}
	}


}