@Run
Feature: Movie Title Display Page - Rate Film
  This should demonstrate the candidate’s ability to structure Gherkin feature files, and include new steps that describe
  the content of the page. There is no need to provide implementation for these steps.

  Background:
    Given I open the homepage
    And I login with user "username"

  Scenario: Rate the Film

    Given I am on the display page for  "The Imitation Game"
    When  I press the button for "Rate This"
    And I click the value star rating of "7"
    Then the "Star Rating" displays a value of "7"
