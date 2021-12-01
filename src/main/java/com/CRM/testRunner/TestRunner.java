package com.CRM.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//Anand//IdeaProjects//CucumberFrameworkProject//src//main//java//com//CRM//features//Login.feature",
        glue = "com\\CRM\\stepDefinations",
        dryRun = false

)



public class TestRunner {
}
