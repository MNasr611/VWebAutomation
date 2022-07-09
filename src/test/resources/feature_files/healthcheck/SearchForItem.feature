Feature: Get Search Resutls

  Scenario: Search For Item And Validate The Search Results Are Correct
    Given Open Google and perform a search for "Cars in London".
    And   Get all search results displayed the number of the Ad links is greater than 0
    Then  Navigate to each Ad link and confirm the title is displayed.

