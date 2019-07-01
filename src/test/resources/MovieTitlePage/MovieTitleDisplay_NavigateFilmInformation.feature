@Run
Feature: Movie Title Display Page - Navigate Film Information
  This should demonstrate the candidate’s ability to structure Gherkin feature files, and include new steps that describe
  the content of the page. There is no need to provide implementation for these steps.

  Background:
    Given I open the homepage
    And I login with user "username"

  Scenario: Selecting Full Cast and Crew

    Given I am on the display page for "The Imitation Game"
    When  I select the link for "Full Cast and Crew"
    Then the "Full Cast and Crew" data is displayed for "The Imitation Game"

  Scenario: Selecting Trivia

    Given I am on the display page for "The Imitation Game"
    When  I select the link for "Trivia"
    Then the "Trivia" data is displayed for "The Imitation Game"

  Scenario: Selecting User Reviews

    Given I am on the display page for "The Imitation Game"
    When  I select the link for "User Reviews"
    Then the "User Reviews" data is displayed for "The Imitation Game"
