package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement UserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement Password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement LoginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement Title;

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

    public String getTittle() {
        return Title.getText();
    }
}
