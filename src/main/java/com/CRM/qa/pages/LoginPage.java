package com.CRM.qa.pages;


import com.CRM.qa.utility.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	private WebDriver driver;

	@FindBy(name = "login:usernameDecorate:username")
	WebElement username;

	//private By username = By.name("login:usernameDecorate:username");
	private By password = By.id("login:passwordDecorate:password");
	private By submit = By.id("login:login");
	private By login = By.xpath( "//a[normalize-space()='Log in']");
	private By cp_account = By.id("login-subdomain");
	private By go_to_login = By.id("login-button");

	
	// Constructor to initialize Web elements
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Method to return login page title to verify after launching url we land on login page
	public String loginPageTitle()
	{
		return driver.getTitle();
	}

	public void clickOnLoginBtn()
	{
		driver.findElement(login).click();
	}

	public void enterDomainName()
	{
		driver.findElement(cp_account).sendKeys(PropertyReader.getProp("domain_name"));
	}
	
	// Method to Login into account
	public  HomePage login(String uname, String pwd)
	{
		driver.findElement(go_to_login).click();
		//driver.findElement(username).sendKeys(uname);
		username.sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submit).click();
		return new HomePage();
	}

	public String homePageTitle()
	{
		return driver.getTitle();
	}
	
	
	
}
