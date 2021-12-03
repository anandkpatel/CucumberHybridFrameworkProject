package com.CRM.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private WebDriver driver;
	@FindBy(xpath = "//a[@aria-label='People & Organisations']")
	WebElement peoplebtn;
	
	@FindBy(xpath = "//span[@class= 'nav-bar-username']")
	WebElement accountbtn;
	
	@FindBy(xpath = "//a[@href= '/settings']")
	WebElement accountsettingBtn;
	
	// Constructor to initialize Web elements
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// Method to click on People button
	public void clickOnPeopleBtn()
	{
		peoplebtn.click();
	}
	
	// Method to navigate to account setting page
	public void goToAccountSettingPage()
	{
		accountbtn.click();
		accountsettingBtn.click();
		
	}
	
	
	
	
	
}
