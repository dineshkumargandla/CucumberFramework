Feature: Testing the Login Page

  Background: Opening application
    Given I have opened the application

  @NegativeTest
  Scenario: Testing the Login Page without passing credentials
    When Click Login without passing username and password
    Then We need to get the 'Error: Username is required.' error message

  @NegativeTest
  Scenario: Testing the Login Page by passing the valid username and empty password
    When Click Login button after entering the username
    Then We need to get the 'Error: The password field is empty.' error message

  @NegativeTest
  Scenario: Testing the Login Page by passing the valid username and invalid password
    When Click Login button after entering the username and invalid password
    Then We need to get the partial error message as 'Error: The password you entered for the username'

  @PositiveTest
  Scenario: Testing the Login Page with Valid Credentials
    Then Login with the valid user
    And make Sure the login happens