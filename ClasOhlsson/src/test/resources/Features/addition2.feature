@tag
Feature: Buying glue
  I want to buy two glue

Background:
Given I have entered Clas Ohlsson site

  @mytag
  Scenario: Add two glues
    Given I have approved cookies
    And I have also added another glue
    When I press add to basket
    Then the result should be 2 glues in basket
