package com.insurance.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentPage {
	
	//declaration
	
	@FindBy(name = "client_id")
	private WebElement clientIdTbx;
	
	@FindBy(name = "month")
	private WebElement monthTbx;
	
	@FindBy(name = "amount")
	private WebElement amountTbx;
	
	@FindBy(name = "due")
	private WebElement dueTbx;
	
	@FindBy(name = "fine")
	private WebElement fineTbx;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	//initialization
	
	public AddPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	
	public WebElement getClientIdTbx() {
		return clientIdTbx;
	}

	public WebElement getMonthTbx() {
		return monthTbx;
	}

	public WebElement getAmountTbx() {
		return amountTbx;
	}

	public WebElement getDueTbx() {
		return dueTbx;
	}

	public WebElement getFineTbx() {
		return fineTbx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void addPaymentDetails(String id,String month,String amount,String due,String fine) {
		
		clientIdTbx.sendKeys(id);
		monthTbx.sendKeys(month);
		amountTbx.sendKeys(amount);
		dueTbx.sendKeys(due);
		fineTbx.sendKeys(fine);
		submitBtn.click();
		
		
	}
	
	
}
