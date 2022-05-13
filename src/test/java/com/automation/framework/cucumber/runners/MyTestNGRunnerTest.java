package com.automation.framework.cucumber.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        //plugin = {"html:target/cucumber/cucumber.html","summary", "pretty"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.automation.framework.cucumber.stepdefinations","com.automation.framework.cucumber.hooks"},
        features = "src/test/java/com/automation/framework/cucumber/feature",
        monochrome = true
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {

}
