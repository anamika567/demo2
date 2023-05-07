package HandleCookies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCookies {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		// How to capture cookies from browser
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of cookies: "+cookies.size());
		
		// How to print cookies from browser
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+" ->"+cookie.getValue()+" ->"+cookie.getDomain()+"-> "+cookie.getPath()+"-> "+cookie.getExpiry());
		}
		
		// How to add cookies to the browser
		 Cookie cookieObj=new Cookie("Mycookie125", "54611ccd6");
		 driver.manage().addCookie(cookieObj);
		 
		cookies= driver.manage().getCookies();
		System.out.println("Size after adding: "+cookies.size());
		
		// How to delete specific cookie from browser
		//driver.manage().deleteCookie(cookieObj);  // by object
		driver.manage().deleteCookieNamed("Mycookie125"); // by name
		cookies= driver.manage().getCookies();
		System.out.println("Size after deletion: "+cookies.size());
		
		// How to delete all cookies
		driver.manage().deleteAllCookies();
		cookies= driver.manage().getCookies();
		System.out.println("delete all cookies: "+cookies.size());

		
		driver.close();
	}

}
