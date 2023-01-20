package com.insurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	
	@FindBy(name="username")
	private WebElement usernameTbx;
	
	@FindBy(name="password")
	private WebElement passwordTbx;
	
	@FindBy(xpath="//button[.='login']")
	private WebElement loginBtn;
	
	
	//initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	//utilization
	
	public WebElement getUsernameTbx() {
		return usernameTbx;
	}


	public WebElement getPasswordTbx() {
		return passwordTbx;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void loginToApp(String userName,String password)
	{
		usernameTbx.sendKeys(userName);
		passwordTbx.sendKeys(password);
		loginBtn.click();
	}
	
	
	

}
