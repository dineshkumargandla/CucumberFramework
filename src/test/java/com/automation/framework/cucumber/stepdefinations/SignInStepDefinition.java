package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.Pages.LoginPage;
import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class SignInStepDefinition{

    LoginPage loginIn = new LoginPage();
    @When("I have opened the application")
    public void i_have_opened_the_application() {
        // Write code here that turns the phrase above into concrete actions

        Waits.forLoading(50);
    }

    @Then("Login with the valid user")
    public void login_with_the_valid_user() {
        // Write code here that turns the phrase above into concrete actions
        loginIn.enterUserName();
        loginIn.enterPassword();
        loginIn.clickLoginButton();
    }

    @And("make Sure the login happens")
    public void make_sure_the_login_happens() {
        // Write code here that turns the phrase above into concrete actions
        String expectedValue = loginIn.getTittle();
        Assert.assertEquals("PRODUCTS", expectedValue);
    }
}
