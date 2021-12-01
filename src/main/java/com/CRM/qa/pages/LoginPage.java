package com.CRM.qa.pages;

import com.CRM.qa.testbase.BaseClass;
import com.CRM.qa.utility.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseClass
{
	@FindBy(name =  "login:usernameDecorate:username")
	WebElement username;
	
	@FindBy(id = "login:passwordDecorate:password")
	WebElement password;
	
	@FindBy(id = "login:login")
	WebElement submit;
	
	@FindBy(xpath = "//a[normalize-space()='Log in']")
	WebElement login;
	
	@FindBy(id = "login-subdomain")
	WebElement cp_account;
	
	@FindBy(id = "login-button")
	WebElement go_to_login;
	
	// Constructor to initialize Web elements
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}

	// Method to return login page title to verify after launching url we land on login page
	public String loginPageTitle()
	{
		return driver.getTitle();
	}

	public void clickOnLoginBtn()
	{
		login.click();
	}

	public void enterDomainName()
	{
		cp_account.sendKeys(PropertyReader.getProp("domain_name"));
	}
	
	// Method to Login into account
	public  HomePage login(String uname, String pwd)
	{
		go_to_login.click();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}

	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	
	
}
