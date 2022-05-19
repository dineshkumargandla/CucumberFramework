Feature: Testing the Search and filter feature

  Background:
    Given After opening the application click on the store tab menu


  @PositiveTest
  Scenario: Testing the Filter price side bar
    When Adjust the filter to certain price
    Then results should not be greater than the max price filter

  @PositiveTest
  Scenario: Testing the search feature
    When Search for "Shoes"
    Then Search result should return "Shoes"

  @PositiveTest
  Scenario: Testing the Shopping cart and Add to cart option
    Given Open the Application  and select the Mens section
    When Selecting the Basic Blue Jeans in the mens section
    Then 1 item is added to the Shopping cart


