package com.automation.framework.cucumber.stepdefinations;


import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.automation.framework.cucumber.constants.Constants.*;
import static com.automation.framework.cucumber.constants.CredentialsConstants.*;

public class SignInTest {


    @When("I have opened the application")
    public void i_have_opened_the_application() {
        Waits.forLoading(50);
        Waits.forElementToBeDisplayed(30, HOME_PAGE.isAccountTabDisplayed(),"Account tab ");
        HOME_PAGE.ClickAccountMenu();
        Waits.forElementToBeDisplayed(30, LOGIN_PAGE.getUserNameTextBox(),"Login Text Box");
    }

    @Then("Login with the valid user")
    public void login_with_the_valid_user() {
        LOGIN_PAGE.enterUserName(REGISTERED_USER_NAME);
        LOGIN_PAGE.enterPassword(VALID_PASSWORD);
        LOGIN_PAGE.clickLoginButton();
    }

    @And("make Sure the login happens")
    public void make_sure_the_login_happens() {
        Assert.assertTrue(USER_ACCOUNT_PAGE.getUserName());
        USER_ACCOUNT_PAGE.clickLogOutButton();
    }

    @Then("Click Login without passing username and password")
    public void click_login_without_passing_username_and_password() {
        LOGIN_PAGE.clickLoginButton();
    }

    @And("We need to get the {string} error message")
    public void we_need_to_get_the_error_message(String string) {
       Assert.assertEquals(string,LOGIN_PAGE.getErrorMessage());
    }
    @Then("Click Login button after entering the username")
    public void click_login_button_after_entering_the_username() {
        LOGIN_PAGE.enterUserName(REGISTERED_USER_NAME);
        LOGIN_PAGE.clickLoginButton();
    }
    @Then("Click Login button after entering the username and invalid password")
    public void click_login_button_after_entering_the_username_and_invalid_password() {
        LOGIN_PAGE.enterUserName(REGISTERED_USER_NAME);
        LOGIN_PAGE.enterPassword(INVALID_PASSWORD);
        LOGIN_PAGE.clickLoginButton();
    }
    @And("We need to get the partial error message as {string}")
    public void we_need_to_get_the_partial_error_message_as(String string) {
        String userName = REGISTERED_USER_NAME;
        Assert.assertEquals(string,LOGIN_PAGE.getErrorMessageInvalidPassword(userName));
    }
}
