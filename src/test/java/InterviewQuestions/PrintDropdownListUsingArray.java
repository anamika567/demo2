package InterviewQuestions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class PrintDropdownListUsingArray {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/campaign/landing.php?campaign_id=14884913640&extra_1=s%7Cc%7C589460569849%7Cb%7Cfacebook%20%27%7C&placement=&creative=589460569849&keyword=facebook%20%27&partner_id=googlesem&extra_2=campaignid%3D14884913640%26adgroupid%3D128696220912%26matchtype%3Db%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-327195741349%26loc_physical_ms%3D1007768%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjwvpCkBhB4EiwAujULMnT_HwrlVnmIGxUVgd7CfXrPFz8Dq1jDazOrAWRGjEnHP4bdOifT4RoCa10QAvD_BwE");
		WebElement ListBox = driver.findElement(By.xpath("//select[@id='month']"));
		Select s=new Select(ListBox);
		List<WebElement> allOptions = s.getOptions();
		int count=allOptions.size();
		
		// Using Array
		String arr[]=new String[count]; 
		for(int i=0;i<count;i++)
		{	
			arr[i]=allOptions.get(i).getText();	
		}
		 for(String x: arr)
		 {
			 System.out.print(x+" ");
		 }
		 
		 // Using Iterator
		 Iterator<WebElement> itr = allOptions.iterator();
		 while(itr.hasNext()) 
		 {
		     System.out.println(itr.next().getText());
		 }

	}

}
