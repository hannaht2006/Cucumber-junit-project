Feature: User should be able login Web table with valid credentials

  @wip
  Scenario: login scenario with 1 param
    Given user is on login page of the web table app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks on login button
    Then user should see url contains orders
