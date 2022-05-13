package com.automation.framework.cucumber.runners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType.UNDERSCORE;


@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html",
        "summary", "pretty"},
        glue = {"com.automation.framework.cucumber.stepdefinations","com.automation.framework.cucumber.hooks"},
        features = "src/test/java/com/automation/framework/cucumber/feature",
        monochrome = true
)
public class MyTestNGRunnerTest extends AbstractTestNGCucumberTests {


}
