
Feature: Google search functionality

  User story: As a user, when I'm on the Google search page,
  I should be able search whatever I want and will see relevant information


  Scenario: Search functionality result title verification
    Given User is on Google search page
    When User types apple in the google search box and clicks enter
    Then User sees apple – Google Search is in the google title

    #if you want to search different item (test data) in Google --> put item in String by put "" (this is called parameterize)

  Scenario: Search functionality result title verification
    Given User is on Google search page
    When User types "tesla" in the google search box and clicks enter
    Then User sees "tesla - Google Search" is in the google title