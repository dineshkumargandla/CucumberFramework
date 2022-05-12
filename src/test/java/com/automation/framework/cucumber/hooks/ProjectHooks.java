package com.automation.framework.cucumber.hooks;

import com.automation.framework.cucumber.Pages.BasePage;
import com.automation.framework.cucumber.setup.InitializeDriver;
import com.automation.framework.cucumber.utils.Configuration;
import com.automation.framework.cucumber.utils.DateAndTimeUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class ProjectHooks {
    private WebDriver driver;

    @Before
    public void before(Scenario scenario) {
        System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());

        System.out.println("Scenario stated executing at " + DateAndTimeUtils.getCurrentDate() + " and " +DateAndTimeUtils.getCurrentTime());
        driver = InitializeDriver.initializeDriver("chrome");
        driver.get(Configuration.getApplicationUrl());
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        System.out.println("Scenario execution ended at  " + DateAndTimeUtils.getCurrentDate() + " and " +DateAndTimeUtils.getCurrentTime());
            driver.quit();
    }
}
