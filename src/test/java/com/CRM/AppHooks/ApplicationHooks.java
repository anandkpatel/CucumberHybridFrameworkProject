package com.CRM.AppHooks;

import com.CRM.qa.testbase.DriverFactory;
import com.CRM.qa.utility.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    //private ConfigReader configReader;
    //Properties prop;




    @Before(order = 0)
    public void launchBrowser() {
        String browserName = PropertyReader.getProp("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeBrowser(browserName);

    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }

}
