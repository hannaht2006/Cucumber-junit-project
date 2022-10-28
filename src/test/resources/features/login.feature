@smoke @Regression @Login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to different accounts.
  and dashboard should be displayed.

  Accounts are: librarian, student, admin

  #Background here is very similar to @BeforeMethod in TestNG.it runs before each scenario
  Background:For the scenarios in the feature file, user is expected to be on the login page
    Given user is on the library login page

  @smoke @librarian @employee
  Scenario: Login as librarian
 #   Given user is on the library login page
    When user enters librarian username
    And user enters librarian password
    Then user should see dashboard

@student
  Scenario: Login as student
  #  Given user is on the library login page
    When user enters student username
    And user enters student password
    Then user should see dashboard

  @admin @employee
  Scenario: Login as admin
 #   Given user is on the library login page
    When user enters admin username
    And user enters admin password
    Then user should see dashboard