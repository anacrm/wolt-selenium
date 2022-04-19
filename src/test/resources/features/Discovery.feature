@wolt
@Discovery

Feature: Wolt - Discovery Page

  Background:
    Given I access the Discovery page
    When I accept the cookies from discovery page

  Scenario: Validate restaurant options

    When I click on Restaurants button
    Then I should be present to a list of restaurants

  Scenario: Validate Stores options

    And I click on Stores button
    Then I should be present to a list of Stores




