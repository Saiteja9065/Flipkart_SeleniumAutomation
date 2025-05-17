Feature: To Validate Hover functionality in flipkart application

Background:
    
    Given user launched the flipkart application
    When user close the popup
    Then user must navigate to home page

Scenario: To Validate Hover functionality

    Given user selects the Fashion category
    When user hovers and clicks on the Baby and Kids category
    And user moved the cursor to outdoor toys 
    And user clicks on price high to low link
    Then user must see relevant products based on the selected category