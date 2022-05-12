package com.automation.framework.cucumber.setup;

import com.automation.framework.cucumber.utils.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitializeDriver {
    public static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {

        switch (Configuration.getBrowserName()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Configuration.getDriverPath());
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
            default:
                throw new IllegalStateException("INVALID BROWSER: " + browser);
        }
        return driver;
    }
}
