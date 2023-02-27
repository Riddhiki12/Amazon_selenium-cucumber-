Feature: Search a product feature

 Scenario: Verify that the user is able to search for a product
    Given the user navigates to the home page
    When the user enter the product name
    Then the product result should be displayed


   Scenario: Verify when the user search for unknown product
     Given the user navigates to the home page
    When the user enter the unknown product name
    Then the  unknown product result should be displayed


  Scenario: Verify that the user checks with the deals and discount
    Given the user navigates to the home page
    When the user checks for deals and discounts
   Then the deals result should be displayed


  Scenario: Verify that the user able to search for customer service
      Given the user navigates to the home page
      When the user checks with the customer service
      Then the customer service result should be displayed


  Scenario Outline: Verify that the user is able to search by the category
    Given the user navigates to the home page
     When the user enters the product name
    And User  searches for Echo Smart Speakers & Displays
    Then the Category search result should be displayed
    Examples:
    | Alexa |
    | Echo Smart Speakers & Display |








