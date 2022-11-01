
Feature: User should be able login Web table with valid credentials

  Background:
    Given user is on login page of the web table app


  Scenario: login scenario with 1 param
 #   Given user is on login page of the web table app
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks on login button
    Then user should see url contains orders


  Scenario: login scenario with 2 param
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains orders


  Scenario: Login scenario with data table

    When user enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains orders

  @wip
  Scenario Outline: Login scenario with data table
    When user enters username "<Username>" password "<Password>" and logins
    Then user should see url contains orders

    Examples:
      | Username | Password |
      | Test     | Tester   |
      | Test     | Tester   |
      | Test     | Tester   |
      | Test     | Tester   |
