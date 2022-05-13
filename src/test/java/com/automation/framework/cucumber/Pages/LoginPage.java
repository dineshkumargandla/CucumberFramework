package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//strong[1]")
    private WebElement UserNameTittle;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement ErrorMessage;

    @FindBy(xpath = "//div[@id='content']//li[1]")
    private WebElement ErrorMessageInvalidPassword;

    public void enterUserName() {
        UserName.clear();
        UserName.sendKeys("dinezh");
    }

    public void enterPassword() {
        Password.clear();
        Password.sendKeys("secret_sauce");
    }

    public void clickLoginButton() {
        LoginButton.click();
    }

    public boolean getUserName() {
        boolean isUserNamePresent = UserNameTittle.isDisplayed();
        return  isUserNamePresent;
    }

    public String getErrorMessage() {
        String errorMessage = ErrorMessage.getText();
        return  errorMessage;
    }

    public WebElement getUserNameTextBox() {
        return UserName;
    }

    public String getErrorMessageInvalidPassword(String userName) {
        String errorMessage = ErrorMessageInvalidPassword.getText();
        int sepPos = errorMessage.lastIndexOf(userName);
        System.out.println("Substring before last separator = "+errorMessage.substring(0,sepPos));
        return  errorMessage.substring(0,sepPos).trim();
    }
}
