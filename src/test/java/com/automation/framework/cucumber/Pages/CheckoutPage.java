package com.automation.framework.cucumber.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.framework.cucumber.constants.Constants.BASE_PAGE;
import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[@class='product-price']//bdi")
    private WebElement ProductPrice;

    @FindBy(xpath = "//td[@class='product-subtotal']//bdi")
    private WebElement SubTotal;

    public float getProductPrice() {
        BASE_PAGE.highlight(driver,ProductPrice);
        return Float.parseFloat(ProductPrice.getText().replace("$", ""));
    }

    public float getSubtotalPrice() {
        BASE_PAGE.highlight(driver,SubTotal);
        return Float.parseFloat(SubTotal.getText().replace("$", ""));
    }
}
