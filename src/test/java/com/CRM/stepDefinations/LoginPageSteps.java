package com.CRM.stepDefinations;

import com.CRM.qa.pages.LoginPage;
import com.CRM.qa.testbase.BaseClass;
import com.CRM.qa.testbase.DriverFactory;
import org.junit.Assert;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class LoginPageSteps {


   LoginPage lg = new LoginPage(DriverFactory.getDriver());

    @Then("User should be on Login page")
    public void user_should_be_on_login_page() {
        DriverFactory.getDriver().get("https://capsulecrm.com/");
        Assert.assertEquals("Login Page Title","CRM Made Simple | Capsule", lg.loginPageTitle());
    }
    @Then("user click on Login button")
    public void user_click_on_login_button() {
        lg.clickOnLoginBtn();
    }

    @Then("User Enters Domain name {string}")
    public void user_enters_domain_name(String string) {
        lg.enterDomainName();
    }

    @Then("User enters Username as {string} and Password as {string} and click on Submit button")
    public void user_enters_username_as_and_password_as_and_click_on_submit_button(String uname, String pwd) {
        lg.login(uname, pwd);

    }

    @Then("User should be on Home page and title should be {string}")
    public void user_should_be_on_home_page_and_title_should_be(String string) {
        System.out.println("Home page Title is --> " + lg.homePageTitle());
        Assert.assertEquals("Home Page Title", "Dashboard | na CRM1", lg.homePageTitle());
    }




}
