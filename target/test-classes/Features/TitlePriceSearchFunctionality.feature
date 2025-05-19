Feature: To Validate click on search icon functionality

Background:
    
    Given user launched the flipkart application
    When user close the popup
    Then user must navigate to home page

Scenario: To Validate Printing of Title Price and Search

    Given user enter search text in search box
    When user clicks the search icon
    Then user must see his/her search result and get title and price