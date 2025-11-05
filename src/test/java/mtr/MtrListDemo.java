package mtr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MtrListDemo {

	public static void main(String[] args) {

		        //ArrayList<String> al = new ArrayList<String>();
				//ArrayList<String> al1 = new ArrayList<String>();
		
				HashSet<String> set=new HashSet<String>();
				WebDriver driver = new ChromeDriver();

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.get("C:/Users/hp/Desktop/mtrdemo.html");

				WebElement mtrlist = driver.findElement(By.id("mtr"));
				
				Select s = new Select(mtrlist);
				
				List<WebElement> option = s.getOptions();
				int count=0;
		        String op="poori";
				for (int i = 0;i<option.size();i++) 
				{
				
					String text = option.get(i).getText();
					// System.out.println(text);
					/*
					 * if(text.equals("poori"))
					 *  { 
					 *  s.selectByVisibleText(text); 
					 *  }
					 */

					// s.selectByIndex(i);
					/*
					 * if(set.add(text)==false) 
					 * { 
					 * System.out.println(text); 
					 * }
					 */

					/*
					 * al.add(text);
					 * al1.add(text); 
					 * Collections.sort(al);
					 */
					/*
					 * if(text.equals(op)) 
					 * { 
					 * count++;
					 * }
					 */
					set.add(text);
					
				}
				
				ArrayList<String> al = new ArrayList<String>(set);
				
				Collections.sort(al);
				System.out.print(al);
				
				/*
				 * if(count==0) 
				 * { 
				 * System.out.println("not present"); 
				 * } 
				 * else if(count==1)
				 * {
				 * System.out.println("is present");
				 * }
				 * else if(count>1)
				 * {
				 * System.out.println("dublicate present"); 
				 * }
				 */
				/*
				 * if(al.equals(al1)) 
				 * { 
				 * System.out.println("in order"); 
				 * } 
				 * else
				 * {
				 * System.out.println("not inn order");
				 * }
				 */

				/*
				 * Collections.sort(al);
				 * 
				 * for(String ol:al) 
				 * { 
				 * System.out.println(ol); 
				 * }
				 */

				/*
				 * for(int i=option.size()-1;i>=0;i--) 
				 * { 
				 * s.deselectByIndex(i);
				 * }
				 */

				// s.selectByVisibleText("bisibath");


	}

}
