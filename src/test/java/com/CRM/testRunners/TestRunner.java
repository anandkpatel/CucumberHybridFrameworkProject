package com.CRM.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//Anand//IdeaProjects//CucumberFrameworkProject//src//main//java//com//CRM//qa//features//LoginPage.feature",
        glue = {"com\\CRM\\stepDefinations", "com\\CRM\\AppHooks" },
        dryRun = false,
        plugin = {"progress"},
        monochrome = true

)



public class TestRunner {
}
