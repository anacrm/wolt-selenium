@wolt
@restaurant
Feature: Wolt - Restaurant Page

  Background:
    Given I access the specific restaurant page
    When I accept the cookies from restaurant page

  Scenario: Validate shopping cart

    And I Choose an item on the menu
    And I click on add order button
    Then The cart view button should show the price €3.00

  Scenario: Validate shopping cart - multiple items

    And I Choose an item on the menu 55
    And I click on add order button
    And I Choose an item on the menu 56
    And I click on add order button
    Then The cart view button should show the price €6.00

  Scenario: Validate shopping cart - Item with required options
    And I Choose an item on the menu 22
    And I click on add order button
    Then The option form should to keep available and required message be presented


  Scenario Outline: Validate shopping cart - different items

    And I Choose an item on the menu <itemIndex>
    And I click on add order button
    Then The cart view button should show the price <price>

    Examples:
      | itemIndex | price |
      | 56        | €3.00 |
      | 57        | €3.00 |
      | 58        | €3.00 |
      | 59        | €3.00 |

