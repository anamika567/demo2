package com.insurance.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentsPage {
	
	//declaration
	
	@FindBy(linkText = "Add Payment")
	private WebElement addPaymentBtn;
	
	//initialization
	
	public PaymentsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getAddPaymentBtn() {
		return addPaymentBtn;
	}
}
