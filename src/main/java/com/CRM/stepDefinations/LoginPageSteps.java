package com.CRM.stepDefinations;

import com.CRM.qa.pages.LoginPage;
import com.CRM.qa.testbase.BaseClass;
import org.junit.Assert;
import io.cucumber.java.en.*;

import java.net.MalformedURLException;

public class LoginPageSteps extends BaseClass {

   // public LoginPage lg;

    @Given("User Launch browser")
    public void user_launch_browser() throws MalformedURLException {
        //lg = new LoginPage();
        BaseClass.browserInitialization();
        driver.getTitle();
        loginpage = new LoginPage();
    }
    @When("User enters website URL")
    public void user_enters_website_url() {
        BaseClass.launchURL();
    }
    @Then("User should be on Login page")
    public void user_should_be_on_login_page() {
        Assert.assertEquals("Login Page Title","CRM Made Simple | Capsule", loginpage.loginPageTitle());
    }
    @Then("user click on Login button")
    public void user_click_on_login_button() {
        loginpage.clickOnLoginBtn();
    }

    @Then("User Enters Domain name {string}")
    public void user_enters_domain_name(String string) {
        loginpage.enterDomainName();
    }
    @Then("User enters Username as {string} and Password as {string} and click on Submit button")
    public void user_enters_username_as_and_password_as_and_click_on_submit_button(String uname, String pwd) {
        loginpage.login(uname, pwd);

    }

    @Then("User should be on Home page and title should be {string}")
    public void user_should_be_on_home_page_and_title_should_be(String string) {
        Assert.assertEquals("Home Page Title", "Dashboard | na CRM", loginpage.homePageTitle());
    }




}
