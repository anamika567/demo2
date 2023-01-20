package com.insurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsertInfoPage {
	
	@FindBy()
	private WebElement successfullMsg;
	
	public InsertInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSuccessfullMsg() {
		return successfullMsg;
	}
	
	

	
	
}
