Feature: To Validate AddToCart functionality in flipkart application

Background:
    
    Given user launched the flipkart application
    When user close the popup
    Then user must navigate to home page

Scenario: To Validate Add to cart functionality
 
    Given user moves to login link
    When user clicks on flipkart plus zone
    And user moves to house and Furniture category
    And user goes to clocks page and selects price
    And user selects his required item
    Then user enters pincode to check if item can be delivered