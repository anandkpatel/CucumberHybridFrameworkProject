package com.CRM.qa.testbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /**
     *  This method is used to initialize browser which is thread Local
     * @param browser
     * @return the instance of the passed Webdriver
     */
    public WebDriver initializeBrowser(String browser)
    {
        System.out.println("browser is --> " + browser);
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else {
            System.out.println("Please enter browser value in config.properties file");
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();


    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }




}
