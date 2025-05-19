Feature: To Validate Filter functionality in flipkart application

Background:
    
    Given user launched the flipkart application
    When user close the popup
    Then user must navigate to home page

Scenario: To Validate filter functionality

    Given user enter text in search box
    When user click on search button
    Then user must navigate to search result page
    And user apply Minimum and maximum amount
    # And user selects the Brand
    And user selects the ram capacity
    And user selects the battery capacity
    Then user must see the filtered products based on the applied filters
