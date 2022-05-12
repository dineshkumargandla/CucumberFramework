package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.Pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupStepDefinition {

    SignUpPage signUp = new SignUpPage();
    @When("I am a new user and opened the application")
    public void i_am_a_new_user_and_opened_the_application() {
        // Write code here that turns the phrase above into concrete actions
        signUp.clickAccountButton();
    }

    @Then("Create a new User")
    public void create_a_new_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("Validate the created user")
    public void validate_the_created_user() {
        // Write code here that turns the phrase above into concrete actions

    }
}
