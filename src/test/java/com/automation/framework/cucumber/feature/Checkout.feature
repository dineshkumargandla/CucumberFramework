Feature: Testing the Checkout Feature

  @PositiveTest
  Scenario Outline: Testing the Shopping cart and Add to cart option
    Given Open the Application  and select the Mens section
    When Selecting the Basic Blue Jeans of <Number of quantity> quantity  in the mens section
    Then  <Number of quantity> item Should added to the Shopping cart
    And Price should be multiple of <Number of quantity>
    Examples:
      |Number of quantity|
      | 10 |

