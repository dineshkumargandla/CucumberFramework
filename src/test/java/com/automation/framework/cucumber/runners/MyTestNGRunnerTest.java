package com.automation.framework.cucumber.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "summary",
                "pretty"},
        glue = {"com.automation.framework.cucumber.stepdefinations",
                "com.automation.framework.cucumber.hooks"},
        features = "src/test/java/com/automation/framework/cucumber/feature",
        //tags = "@NegativeTest,@PositiveTest",
        monochrome = false
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {
/*   @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}

