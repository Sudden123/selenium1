#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Calculator
  In order to avoid silly mistakes As a math idiot I want to be able to be told the sum of two numbers

Background:
Given I am logged in

  @mytag
  Scenario: Add two numbers
    Given I have entered 50 into the calculator
    And I have also entered 50 into the calculator
    When I use add
    Then the result should be 100 on the screen
   
