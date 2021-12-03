package com.CRM.AppHooks;

import com.CRM.qa.testbase.DriverFactory;
import com.CRM.qa.utility.PropertyReader;
import com.CRM.qa.utility.ScreenShotUtils;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks {

    private DriverFactory driverfactory;
    private WebDriver driver;

    @Before(order = 0)
    public void setUp()
    {
        String Browser = PropertyReader.getProp("browser");
        driverfactory = new DriverFactory();
        driver = driverfactory.initializeBrowser(Browser);
    }

    @After(order = 0)
    public void quitBrowser()
    {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario)
    {
        if(scenario.isFailed())
        {
           // Steps to capture screen shot in cucumber report
            byte [] path = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(path, "image/png", scenario.getName().replace(" ", "_"));
        }
    }
}
