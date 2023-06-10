package HandlingBrowserWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowscenario {

//	Practise Exercise : Try to implement the following scenario, where you can print text from the main window after switching back to the parent window.
//
//	Open the URL  " https://demoqa.com/browser-windows".
//	Click on all the child windows
//	Print the text present on all the child windows in the console.
//	Print the heading of the parent window in the console.

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
        
        driver.findElement(By.id("windowButton")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {

                    driver.switchTo().window(ChildWindow);
                    WebElement text = driver.findElement(By.id("sampleHeading"));
                    System.out.println("Text of child window is " + text.getText());
                    driver.close();

                }
                
                driver.switchTo().window(mainwindow);
                System.out.println(driver.getTitle());
	}

	}
}
