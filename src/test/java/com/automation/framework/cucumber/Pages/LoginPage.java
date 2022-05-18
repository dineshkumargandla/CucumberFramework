package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.constants.Constants.BASE_PAGE;
import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement Password;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement LoginButton;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement ErrorMessageInvalidPassword;

    public void enterUserName(String userName) {
        BASE_PAGE.highlight(driver,UserName);
        UserName.clear();
        UserName.sendKeys(userName);
    }

    public void enterPassword(String password) {
        BASE_PAGE.highlight(driver,Password);
        Password.clear();
        Password.sendKeys(password);
    }

    public void clickLoginButton() {
        BASE_PAGE.highlight(driver,LoginButton);
        LoginButton.click();
    }

    public String getErrorMessage() {
        BASE_PAGE.highlight(driver,ErrorMessage);
        String errorMessage = ErrorMessage.getText();
        return  errorMessage;
    }

    public WebElement getUserNameTextBox() {
        BASE_PAGE.highlight(driver,UserName);
        return UserName;
    }

    public String getErrorMessageInvalidPassword(String userName) {
        BASE_PAGE.highlight(driver,ErrorMessageInvalidPassword);
        String errorMessage = ErrorMessageInvalidPassword.getText();
        int sepPos = errorMessage.lastIndexOf(userName);
        return  errorMessage.substring(0,sepPos).trim();
    }
}
