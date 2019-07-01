@Run
Feature: Movie Title Display Page - Watchlist
  This should demonstrate the candidate’s ability to structure Gherkin feature files, and include new steps that describe
  the content of the page. There is no need to provide implementation for these steps.

  Background:
    Given I open the homepage
    And I login with user "username"

  Scenario: Add to WatchList-via Tab

    Given I am on the display page for "The Imitation Game"
    When  I press the button for "Watchlist Tab"
    Then the "watchlist button-tab" must be "green"

  Scenario: View the Watchlist

    Given I am on the display page for  "The Imitation Game"
    When  I hover over the button for "Watchlist Tab"
    And I select from the dropdown list "View Watchlist"
    Then I am taken to the "Watchlist" page where "The Imitation Game" is listed

  Scenario: Remove from the Watchlist-via Tab

    Given I am on the display page for "The Imitation Game"
    When  I press the button for "Watchlist Tab"
    Then the "watchlist button-tab" must be "grey"

  Scenario: Add to WatchList-via Button

    Given I am on the display page for "The Imitation Game"
    When  I press the button for "Watchlist Button"
    Then the "watchlist button" must be "green-bordered"

  Scenario: View the Watchlist

    Given I am on the display page for  "The Imitation Game"
    When  I hover over the button for "Watchlist Tab"
    And I select from the dropdown list "View Watchlist"
    Then I am taken to the "Watchlist" page where "The Imitation Game" is listed

  Scenario: Remove from the Watchlist-via Button

    Given I am on the display page for "The Imitation Game"
    When  I press the button for "Watchlist Button"
    Then the "watchlist button" must be "blue"

  Scenario: Create New Watchlist

    Given I am on the display page for  "The Imitation Game"
    When  I hover over the button for "Watchlist Tab"
    And I select from the dropdown list "New Watchlist"
    Then I am taken to the "Create" page
    And I enter the following details
      | TestList   |
      | Actors I Don't Like |
      | People |
    And I press the button for "Create"


