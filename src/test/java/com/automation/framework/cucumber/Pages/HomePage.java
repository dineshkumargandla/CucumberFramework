package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@id='menu-item-1237']//a[@class='menu-link'][contains(text(),'Account')]")
    private WebElement AccountMenu;

    public void  ClickAccountMenu() {
        AccountMenu.click();
    }

}
