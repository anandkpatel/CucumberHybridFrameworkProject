package com.CRM.qa.testbase;

import com.CRM.qa.utility.CurrentDate;
import com.CRM.qa.utility.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected static WebDriver driver;
    protected static RemoteWebDriver driver1;
    protected static JavascriptExecutor js;
    protected static String currentdate = CurrentDate.currentDate();
    protected BaseClass baseclass;


    // Method to initialize browser (local or remote)
    public static void browserInitialization() throws MalformedURLException {

        String browser = PropertyReader.getProp("browser");
        String url = PropertyReader.getProp("url");
        String grid = PropertyReader.getProp("grid");
        String gridUrl = PropertyReader.getProp("grid_url");
        if (browser.equalsIgnoreCase("chrome")) {

            if (grid.equalsIgnoreCase("yes")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                ChromeOptions options = new ChromeOptions();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(cap);
                driver = new RemoteWebDriver(new URL(gridUrl), cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (grid.equalsIgnoreCase("yes")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setPlatform(Platform.LINUX);
                cap.setBrowserName("firefox");
                FirefoxOptions options = new FirefoxOptions();
                options.merge(cap);
                driver = new RemoteWebDriver(new URL(gridUrl), options);
            } else {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }


        }
        js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //eventHandlerInit();
        driver.get(url);
        driver.manage().deleteAllCookies();

    }

    // This Method Close all instances created by WebDriver
    public static void close() {
        driver.quit();

    }




}
