package com.automation.framework.cucumber.Pages;

import com.automation.framework.cucumber.utils.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class RegisterPage {

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='reg_username']")
    private WebElement UserName;

    @FindBy(xpath = "//input[@id='reg_email']")
    private WebElement Email;

    @FindBy(xpath = "//input[@id='reg_password']")
    private WebElement Password;

    @FindBy(xpath = "//button[@name='register']")
    private WebElement RegisterButton;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement ErrorMessage;


    public void enterUserName(String userName) {
        UserName.clear();
        UserName.sendKeys(userName);
    }

    public void enterEmail(String email) {
        Email.clear();
        Email.sendKeys(email);
    }

    public void enterPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickRegisterButton() {
        RegisterButton.click();
    }

    public WebElement getUserNameTextBox() {
        return UserName;
    }

    public String getErrorMessage() {
        return ErrorMessage.getText();
    }

    public String getJavaScriptValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", Email);
        Log.info(validationMessage);
        return validationMessage.substring(0, validationMessage.indexOf("."));
    }

}
