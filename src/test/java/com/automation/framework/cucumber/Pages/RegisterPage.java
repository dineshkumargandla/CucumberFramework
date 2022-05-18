package com.automation.framework.cucumber.Pages;

import com.automation.framework.cucumber.utils.Log;
import com.automation.framework.cucumber.utils.Waits;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.constants.Constants.BASE_PAGE;
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


    public void enterUserName(String userName) throws InterruptedException {
        Waits.sleep(2000);
        BASE_PAGE.highlight(driver,UserName);
        UserName.clear();
        UserName.sendKeys(userName);
    }

    public void enterEmail(String email) {
        BASE_PAGE.highlight(driver,Email);
        Email.clear();
        Email.sendKeys(email);
    }

    public void enterPassword(String password) {
        BASE_PAGE.highlight(driver,Password);
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickRegisterButton() {
        BASE_PAGE.highlight(driver,RegisterButton);
        RegisterButton.click();
    }

    public WebElement getUserNameTextBox() {
        BASE_PAGE.highlight(driver,UserName);
        return UserName;
    }

    public String getErrorMessage() {
        BASE_PAGE.highlight(driver,ErrorMessage);
        return ErrorMessage.getText();
    }

    public String getJavaScriptValidationMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", Email);
        Log.info(validationMessage);
        return validationMessage.substring(0, validationMessage.indexOf("."));
    }

}
