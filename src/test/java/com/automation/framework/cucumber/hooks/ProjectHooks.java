package com.automation.framework.cucumber.hooks;

import com.automation.framework.cucumber.Helper.GenerateUserName;
import com.automation.framework.cucumber.Pages.BasePage;
import com.automation.framework.cucumber.setup.InitializeDriver;
import com.automation.framework.cucumber.utils.ConfigurationPropertyReader;
import com.automation.framework.cucumber.utils.DateAndTimeUtils;

import io.cucumber.java.*;

import java.io.IOException;

import static com.automation.framework.cucumber.Pages.BasePage.*;

public class ProjectHooks extends InitializeDriver {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Executing Scenario ID : " + scenario.getId() + "," +
                "SCENARIO NAME: " + scenario.getName() + " Feature File name  " + getFeatureFileName(scenario));
        System.out.println("Scenario stated executing at " + DateAndTimeUtils.getCurrentDate() + " and " + DateAndTimeUtils.getCurrentTime());
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException, InterruptedException {
        System.out.println("Execution of Scenario ID : " + scenario.getId() + "," +
                "SCENARIO NAME: " + scenario.getName() + " is completed..!");
        System.out.println("Scenario ended executing at " + DateAndTimeUtils.getCurrentDate() + " and " + DateAndTimeUtils.getCurrentTime());
        if (scenario.isFailed() && ConfigurationPropertyReader.getTakeShootsOnFailure().equalsIgnoreCase("true")) {
            capture(driver, scenario);
        }
    }

    @BeforeAll
    public static void beforeAll() throws IOException {
        GenerateUserName.createRandomUserName();
        driver = InitializeDriver.initializeDriver("chrome");
        driver.get(ConfigurationPropertyReader.getApplicationUrl());
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Scenario execution ended at  " + DateAndTimeUtils.getCurrentDate() + " and " + DateAndTimeUtils.getCurrentTime());
        driver.quit();
    }
}
