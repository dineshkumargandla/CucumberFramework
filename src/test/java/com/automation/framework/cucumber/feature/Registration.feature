Feature: Testing the Registration Page

  Background:
    Given I click the Account tab Registration Page should display


  @NegativeTest
  Scenario Outline: Make a user Registration page without entering the values
    When Click Register button without entering any value
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                             |
      | "Error: Please provide a valid email address." |

  @NegativeTest
  Scenario Outline: Make a user Registration by entering just username
    When Click Register button after entering a sample userName and leaving mail and password empty
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                             |
      | "Error: Please provide a valid email address." |

  @NegativeTest
  Scenario Outline: Make a user Registration by entering just emailAddress
    When Click Register button after entering a sample emailAddress and leaving userName and password empty
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                              |
      | "Error: Please enter a valid account username." |

#  @NegativeTest
#  Scenario: Make a user Registration by entering invalid emailAddress
#    When I click the Account tab Registration Page should display
#    Then Click Register button after entering a sample invalid emailAddress
#    And UserName Should not display
#
#  @NegativeTest
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
    When Click Register button after entering a sample valid emailAddress valid emailAddress and valid userName by leaving the password field empty
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                         |
      | "Error: Please enter an account password." |

  @NegativeTest
  Scenario Outline: Make a user Registration with existing username and unregistered email id
    When Click Register button after entering an already registered user name and unregistered email id
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                                                                   |
      | "Error: An account is already registered with that username. Please choose another." |

  @NegativeTest
  Scenario Outline: Make a user Registration with new username and already registered email id
    When Click Register button after entering an already registered email id and new username
    Then An error message <actualErrorMessage> Should display
    Examples:
      | actualErrorMessage                                                                |
      | "Error: An account is already registered with your email address. Please log in." |

    @PositiveTest
    Scenario: Make a user Registration with new username and new registered email id
      When Click Register button after entering a new email id and new username
      Then An Hello Message should display after successful registration in Account Dashboard page

