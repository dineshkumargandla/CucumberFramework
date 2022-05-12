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

    public void enterUserName() {
        UserName.clear();
        UserName.sendKeys("standard_user");
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
}
