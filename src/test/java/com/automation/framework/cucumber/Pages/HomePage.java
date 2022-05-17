package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='menu-item-1237']//a[@class='menu-link'][contains(text(),'Account')]")
    private WebElement AccountMenu;

    @FindBy(xpath = "//li[@id='menu-item-1227']//a[@class='menu-link'][contains(text(),'Store')]")
    private WebElement StoreMenu;

    public void  ClickAccountMenu() {
        AccountMenu.click();
    }

    public void  ClickStoreMenu() {
        StoreMenu.click();
    }

    public boolean getAccountTab() {
        boolean isUserNamePresent = AccountMenu.isDisplayed();
        return  isUserNamePresent;
    }

    public WebElement isAccountTabDisplayed() {
        return AccountMenu;
    }
}
