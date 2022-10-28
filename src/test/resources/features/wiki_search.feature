Feature: Wikipedia Search Functionality and Verification

  Background: For the scenarios in the feature file, user is expected to be on the wiki search page
    Given User is on Wikipedia home page


  Scenario:Wikipedia Search Functionality Title Verification

    When User types Steve Jobs in the wiki search box
    And User clicks wiki search button
    Then User sees Steve Jobs is in the wiki title


  Scenario:Wikipedia Search Functionality Title Verification

    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  Scenario:Wikipedia Search Functionality header Verification

    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header


  Scenario: Wikipedia Search Functionality Image Header Verification

    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

@scenarioOutlinePractice
  Scenario Outline: Wikipedia Search Functionality Title Verification with using DDT(data driven testing)
   # data driven testing will require table data (require table header) under examples
  #  Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title

    Examples:
      | searchValue       | expectedTitle     |
      | Steve Jobs        | Steve Jobs        |
      | Bill Gate         | Bill Gate         |
      | Cristiano Ronaldo | Cristiano Ronaldo |
      | Elon Musk         | Elon Musk         |
      | Albert Einstein   | Albert Einstein   |
      | Chuck Norris      | Chuck Norris      |
      | Alisher Usmanov  | Alisher Usmanov  |