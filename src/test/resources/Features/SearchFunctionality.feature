Feature: To Validate flipkart application

Background:
    
    Given user launched the flipkart application
    When user close the popup
    Then user must navigate to home page

Scenario: To Validate search functionality

    Given user enter text in search box
    When user click on search button
    Then user must navigate to search result page
    And extract the product names from search result page
    And print the fourth product from the list