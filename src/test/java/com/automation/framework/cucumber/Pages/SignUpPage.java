package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class SignUpPage {

    @FindBy(xpath = "//li[@id='menu-item-1237']//a[@class='menu-link'][contains(text(),'Account')]")
    private WebElement AccountButton;

    public SignUpPage() {
        super();
        PageFactory.initElements(driver,this);
    }

    public void clickAccountButton() {
        AccountButton.click();
    }

}
