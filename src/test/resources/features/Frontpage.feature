#mapping out test requirements
@frontpage
@wolt
Feature: Wolt - Frontpage

  Background:
    Given I access the frontpage
    When I accept the cookies from frontpage

  Scenario: Validate address input - Specific Data

    And I enter a specific address Tikkurila
    And I click on search button
    And Select the address
    Then I should be redirected to wolt.com/en/discovery

  Scenario: Validate address input - Current location

    And I click on the address box
    And I Click on use my current location
    Then I should be redirected to wolt.com/en/discovery

  Scenario: Validate view popular link button

    And I Click on view popular link button
    Then I should be redirected either to wolt.com/en/fin/ or wolt.com/en/nor/

