package HandlingBrowserWindow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// getWindowHandle() 
		
//		String windowId = driver.getWindowHandle(); // return id of current window
//		System.out.println(windowId); // window id keep changed
//		
		// getWindowHandles()
		
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
		Set<String> windowIds = driver.getWindowHandles(); // return id's of multiple windows

		//1) First method - using iterator()
		
//		Iterator<String> it=windowIds.iterator();
//		
//		String parentWindowId=it.next();
//		String childWindowId=it.next();
//		
//		System.out.println(parentWindowId);
//		System.out.println(childWindowId);
//	
		
		//2) Second method -using list/ArrayList
		
		List<String> windowIdsList=new ArrayList<String>(windowIds);
		
//		String parentWindowId = windowIdsList.get(0);
//		String child WindowId = windowIdsList.get(1);
//		
//		System.out.println("parent window id:" +parentWindowId);
//		System.out.println("child window id :" +childWindowId);
//		
//		//how to use window id's for switching
//		
//		driver.switchTo().window(parentWindowId);
//		System.out.println("parent window title is:" +driver.getTitle());
//		
//		driver.switchTo().window(childWindowId);
//		System.out.println("child window title is:" +driver.getTitle());
//		
		//3) for each loop
		
//		for(String winID:windowIdsList)
//		{
//			String title = driver.switchTo().window(winID).getTitle();
//			System.out.println(title);
//				
//		}
//		
		//driver.close(); //close single browser window which is pointing
		//driver.quit();  // close all the browser window
		
		for(String winID:windowIdsList)
		{
			String title = driver.switchTo().window(winID).getTitle();
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
		}
		
		
	}

}
