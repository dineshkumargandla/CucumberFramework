package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class UserAccountPage {

    public UserAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//strong[1]")
    private WebElement UserNameTittle;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']")
    private WebElement LogOutButton;


    public boolean getUserName() {
        boolean isUserNamePresent = UserNameTittle.isDisplayed();
        return  isUserNamePresent;
    }
    public boolean userNameNotFound() {
        boolean userNameNotFound = driver.findElements(By.xpath("//strong[1]")).size() < 1;
        return userNameNotFound;
    }

    public void clickLogOutButton() {
        LogOutButton.click();
    }

    public boolean isLogoutButtonDisplayed() {
       return LogOutButton.isDisplayed();
    }
}
