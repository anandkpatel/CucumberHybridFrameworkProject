package com.CRM.qa.utility;

import com.CRM.qa.testbase.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils  {

    public static JavascriptExecutor js;

    public static void Toclick(WebElement element)
    {
        //Wait.elementToBeClickble(element);
        Sleep.sleepWithTime(1500);
        js.executeScript("arguments[0].click();", element);
    }

    public static void scrollByPixl() {
        js.executeScript("window.scrollBy(0,1000)");

    }

    public static void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();",element );

    }

    public static void enterValue(WebDriver driver, String value, WebElement elm )
    {
    JavascriptExecutor j = (JavascriptExecutor)driver;
    j.executeScript("arguments[0].value='" + value +"' ;", elm);
    }






}
