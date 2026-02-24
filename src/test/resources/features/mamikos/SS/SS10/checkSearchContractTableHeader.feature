@SS8
Feature: Search Contract

  @TEST_SS-3361 @TEST_SS-3398
  Scenario: Check Display Table Header on Search Contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    Then admin verify table header row is displayed with name:
      | Contract Id         |
      | Detail Tenant       |
      | Detail Kos          |
      | Contract Period     |
      | Invoices            |
      | From Booking        |
      | Added By Consultant |
      | Check-out Date      |
      | Termination Date    |
      | Harga Sewa          |
      | Deposit             |
      | Status Kontrak      |
      | Action              |
