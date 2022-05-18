package com.automation.framework.cucumber.Pages;

import com.automation.framework.cucumber.setup.InitializeDriver;
import com.automation.framework.cucumber.utils.ConfigurationPropertyReader;
import com.automation.framework.cucumber.utils.DateAndTimeUtils;
import io.cucumber.java.Scenario;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class BasePage extends InitializeDriver {
    static String getCurrentTime = StringUtils.substringBefore(DateAndTimeUtils.getCurrentTime().toString(), ".").replace(":","-");

    public static String getFeatureFileName(Scenario scenario) {
        String fileName = scenario.getUri().toString();
        String featureFileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        return FilenameUtils.removeExtension(featureFileName);
    }
    public static String getScenarioName(Scenario scenario) {
        return scenario.getName().replace(" ", "_");
    }

    public static String generateScreenShotOutputDirectory(Scenario scenario) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ConfigurationPropertyReader.getScreenOutDir());
        stringBuilder.append(File.separator);
        stringBuilder.append(ConfigurationPropertyReader.getProductName());
        stringBuilder.append(File.separator);
        stringBuilder.append(ConfigurationPropertyReader.getProductVersion() + "." + ConfigurationPropertyReader.getProductBuild());
        stringBuilder.append(File.separator);
        stringBuilder.append(DateAndTimeUtils.getCurrentDate());
        stringBuilder.append(File.separator);
        stringBuilder.append(getCurrentTime);
        stringBuilder.append(File.separator);
        stringBuilder.append(getFeatureFileName(scenario));
        stringBuilder.append(File.separator);
        stringBuilder.append(getScenarioName(scenario)+".png");
        return stringBuilder.toString();
    }

    public static void capture(WebDriver driver, Scenario scenario) throws IOException, InterruptedException {
        File file = new File(generateScreenShotOutputDirectory(scenario));
        File parentPath = file.getParentFile();
        if(!parentPath.exists()){
            parentPath.mkdir();
        }
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, file);
    }

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" + "original_style = element.getAttribute('style');"
                + "element.setAttribute('style', original_style + \";"
                + "border: 3px solid red;\");"
                + "setTimeout(function(){element.setAttribute('style', original_style);}, 2000);", element);
    }
}

