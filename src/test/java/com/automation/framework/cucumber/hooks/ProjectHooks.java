package com.automation.framework.cucumber.hooks;

import com.automation.framework.cucumber.Helper.GenerateUserName;
import com.automation.framework.cucumber.setup.InitializeDriver;
import com.automation.framework.cucumber.utils.ConfigurationPropertyReader;
import com.automation.framework.cucumber.utils.DateAndTimeUtils;

import io.cucumber.java.*;

import java.io.IOException;

public class ProjectHooks extends InitializeDriver{
    //private static WebDriver driver;

    @Before
    public  void beforeScenario(Scenario scenario)  {
       System.out.println("BEFORE: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        System.out.println("Scenario stated executing at " + DateAndTimeUtils.getCurrentDate() + " and " +DateAndTimeUtils.getCurrentTime());
    }

    @After
    public  void afterScenario(Scenario scenario)  {
        System.out.println("After THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: " + scenario.getName());
        System.out.println("Scenario ended executing at " + DateAndTimeUtils.getCurrentDate() + " and " +DateAndTimeUtils.getCurrentTime());
    }
    @BeforeAll
    public static void beforeAll() throws IOException {
        GenerateUserName.createRandomUserName();
        driver = InitializeDriver.initializeDriver("chrome");
        driver.get(ConfigurationPropertyReader.getApplicationUrl());
    }


    @AfterAll
    public  static void afterAll() {
        System.out.println("AFTER: THREAD ID : " + Thread.currentThread().getId() + "," +
                "SCENARIO NAME: ");
        System.out.println("Scenario execution ended at  " + DateAndTimeUtils.getCurrentDate() + " and " + DateAndTimeUtils.getCurrentTime());
        driver.close();
    }
}
