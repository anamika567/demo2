package com.insurance.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPaymentPage {
	
	
	@FindBy(name = "month")
	private WebElement monthTbx;
	
	@FindBy(name = "amount")
	private WebElement amountTbx;
	
	@FindBy(name = "due")
	private WebElement dueTbx;
	
	@FindBy(name = "fine")
	private WebElement fineTbx;
	
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement updateBtn;
	
	@FindBy(xpath = "//a[text()='Delete Payment']")
	private WebElement deleteLink;
	
	
	public EditPaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public WebElement getDeleteLink() {
		return deleteLink;
	}
	
	
	public void editPayment(WebDriver driver,String RECIPT_NO)
	{
		driver.findElement(By.xpath("//td[text()='"+RECIPT_NO+"']/following-sibling::td[6]/child::a")).click();
	}
	
	public void deletePayment(WebDriver driver,String RECIPT_NO) 
	{
		driver.findElement(By.xpath("//td[text()='"+RECIPT_NO+"']/following-sibling::td[6]/child::a")).click();
		deleteLink.click();
	}
	
	

	public void setValue(String month,String amount,String due,String fine) {
		
		monthTbx.clear();
		monthTbx.sendKeys(month);
		amountTbx.clear();
		amountTbx.sendKeys(amount);
		dueTbx.clear();
		dueTbx.sendKeys(due);
		fineTbx.clear();
		fineTbx.sendKeys(fine);
		updateBtn.click();
			
	}
	
	
}
