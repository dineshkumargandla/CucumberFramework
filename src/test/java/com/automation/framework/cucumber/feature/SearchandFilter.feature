Feature: Testing the Search and filter feature

  Background:
    Given After opening the application click on the store tab menu

  @PositiveTest
  Scenario: Testing the search feature
    Then Search for "Shoes"
    And Search result should return "Shoes"

  @PositiveTest
  Scenario: Testing the Filter category dropdown
    Then Browse by Categories select "Men "
    And All the items displays should be of "Men"

  @PositiveTest
  Scenario: Testing the Filter price side bar
    Then Adjust the filter to certain price
    And results should not be greater than the max price filter

