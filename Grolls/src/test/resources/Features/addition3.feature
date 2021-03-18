@tag
Feature: Buying glue
  I want to buy two glue

Background:
Given I have entered Grolls site

  @mytag
  Scenario: Add two black t-shirts
    Given I have picked size
    And I have also selected two shirts
    When I press add to basket
    Then the result should be 2 shirts in basket