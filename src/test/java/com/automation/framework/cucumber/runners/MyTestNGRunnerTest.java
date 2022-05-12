package com.automation.framework.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html",
        "summary", "pretty"},
        glue = {"com.automation.framework.cucumber.stepdefinations","com.automation.framework.cucumber.hooks"},
        features = "src/test/java/com/automation/framework/cucumber/feature"
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {


}
