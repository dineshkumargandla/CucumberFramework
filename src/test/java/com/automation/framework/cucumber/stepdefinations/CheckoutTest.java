package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.automation.framework.cucumber.constants.Constants.*;

public class CheckoutTest {

    @And("Price should be multiple of {int}")
    public void price_should_be_multiple_of(int quantity) {
        STORE_PAGE.clickOnShoppingCart();
        Assert.assertEquals(CHECKOUT_PAGE.getProductPrice() * quantity , CHECKOUT_PAGE.getSubtotalPrice());
    }
}
