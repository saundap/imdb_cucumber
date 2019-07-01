@Run
Feature: Movie Title Display Page - Search Return
  This should demonstrate the candidate’s ability to structure Gherkin feature files, and include new steps that describe
  the content of the page. There is no need to provide implementation for these steps.

  Background:
    Given I open the homepage
    And I login with user "username"

  Scenario: Returning the Correct Film from Search

    Given I search for the film "The Imitation Game"
    When I select the listed option for "The Imitation Game"
    Then the page for the selected film must be displayed.
