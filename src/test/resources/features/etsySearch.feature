
Feature: Etsy search functionality

  User Story: As a user, I'm on the Etsy home page
  I should be able search item name wooden spoon and will see the relevant information


  Scenario: Search functionality result title verification
    Given User is on Etsy home page
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title


  Scenario: Search functionality result title verification
    Given User is on Etsy home page
    When User types "Wooden Spoon" in the search box
    And User clicks search button
    Then User sees "Wooden spoon" is in the title