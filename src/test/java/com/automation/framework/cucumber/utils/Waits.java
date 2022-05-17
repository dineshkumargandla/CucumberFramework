package com.automation.framework.cucumber.utils;

import com.automation.framework.cucumber.setup.InitializeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class Waits extends InitializeDriver {

    public Waits(WebDriver driver) {
        this.driver = driver;
    }

    private static void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public static void forLoading(int timeout){
        ExpectedCondition<Object> condition = ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public static void forElementToBeDisplayed(int timeout, WebElement webElement, String webElementName){
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        String timeoutMessage = webElementName + " wasn't displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public static void forPresenceOfElements(int timeout, By elementLocator, String elementName){
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + Integer.toString(timeout) + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }
    public static void implicitWait(int timeout){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }
}
