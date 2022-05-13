package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.Pages.HomePage;
import com.automation.framework.cucumber.Pages.LoginPage;
import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignInTest {

    LoginPage loginIn = new LoginPage();
    HomePage homePage = new HomePage();
    @When("I have opened the application")
    public void i_have_opened_the_application() {
        // Write code here that turns the phrase above into concrete actions
        Waits.forLoading(50);
        homePage.ClickAccountMenu();
        Waits.forElementToBeDisplayed(30, loginIn.getUserNameTextBox(),"Login Text Box");
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
        Assert.assertTrue(loginIn.getUserName());
    }

    @Then("Click Login without passing username and password")
    public void click_login_without_passing_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        loginIn.clickLoginButton();
    }

    @And("We need to get the {string} error message")
    public void we_need_to_get_the_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
       Assert.assertEquals(string,loginIn.getErrorMessage());

    }
    @Then("Click Login button after entering the username")
    public void click_login_button_after_entering_the_username() {
        // Write code here that turns the phrase above into concrete actions
        loginIn.enterUserName();
        loginIn.clickLoginButton();
    }
    @Then("Click Login button after entering the username and invalid password")
    public void click_login_button_after_entering_the_username_and_invalid_password() {
        // Write code here that turns the phrase above into concrete actions
        loginIn.enterUserName();
        loginIn.enterPassword();
        loginIn.clickLoginButton();
    }
    @And("We need to get the partial error message as {string}")
    public void we_need_to_get_the_partial_error_message_as(String string) {
        // Write code here that turns the phrase above into concrete actions
        String userName = "dinezh";
        Assert.assertEquals(string,loginIn.getErrorMessageInvalidPassword(userName));
    }
}
