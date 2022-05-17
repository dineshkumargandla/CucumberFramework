Feature: Testing the Registration Page

  Background:
    When I click the Account tab Registration Page should display
  @NegativeTest
  Scenario Outline: Make a user Registration page without entering the values
    Then Click Register button without entering any value
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                             |
      | "Error: Please provide a valid email address." |

  @NegativeTest
  Scenario Outline: Make a user Registration by entering just username
    Then Click Register button after entering a sample userName and leaving mail and password empty
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                             |
      | "Error: Please provide a valid email address." |

  @NegativeTest
  Scenario Outline: Make a user Registration by entering just emailAddress
    Then Click Register button after entering a sample emailAddress and leaving userName and password empty
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                              |
      | "Error: Please enter a valid account username." |

#  @NegativeTest1
#  Scenario: Make a user Registration by entering invalid emailAddress
#    When I click the Account tab Registration Page should display
#    Then Click Register button after entering a sample invalid emailAddress
#    And UserName Should not display
#
#  @NegativeTest1
#  Scenario: Make a user Registration by entering invalid emailAddress by excluding .com
#    When I click the Account tab Registration Page should display
#    Then Click Register button after entering a sample invalid emailAddress by adding @ and excluding .com
#    And UserName Should not display
#
#
#  @NegativeTest
#  Scenario: Make a user Registration by entering valid emailAddress but ending with @
#    When I click the Account tab Registration Page should display
#    Then Click Register button after entering a sample valid emailAddress but ending with @
#    And UserName Should not display
#
#  @NegativeTest
#  Scenario: Make a user Registration by entering valid emailAddress but ending with @
#    When I click the Account tab Registration Page should display
#    Then Click Register button after entering a sample valid emailAddress but ending with @
#    And UserName Should not display


  @NegativeTest
  Scenario Outline: Make a user Registration by entering valid emailAddress and valid userName and empty password
    Then Click Register button after entering a sample valid emailAddress valid emailAddress and valid userName by leaving the password field empty
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                         |
      | "Error: Please enter an account password." |

  @NegativeTest
  Scenario Outline: Make a user Registration with existing username and unregistered email id
    Then Click Register button after entering an already registered user name and unregistered email id
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                                                                   |
      | "Error: An account is already registered with that username. Please choose another." |

  @NegativeTest
  Scenario Outline: Make a user Registration with new username and already registered email id
    Then Click Register button after entering an already registered email id and new username
    And An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                                                                |
      | "Error: An account is already registered with your email address. Please log in." |

  @PositiveTest
  Scenario: Make a user Registration with new username and new registered email id
    Then Click Register button after entering a new email id and new username
    And An Hello Message should display after successful registration in Account Dashboard page
