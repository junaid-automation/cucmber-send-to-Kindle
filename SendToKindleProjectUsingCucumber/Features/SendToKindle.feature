Feature: Send To Kindle using Cucumber

  Scenario Outline: Login Multiple account in Send to Kindle
    Given Navigate to the Send to Kindle Page login Page
    Then user send all files by passing email and password with the excel "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      
