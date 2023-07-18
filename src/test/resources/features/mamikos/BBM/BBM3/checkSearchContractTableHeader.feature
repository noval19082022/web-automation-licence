@BBM3
Feature: Search Contract

  @TEST_BBM-1395
  Scenario: Display contract id column
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    Then admin verify "Contract Id" column is displayed
