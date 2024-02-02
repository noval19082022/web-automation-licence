@regression @LIMO4
Feature: Admin Mamitour Requested

  @TEST_LIMO-3673 @mamitourAdmin @continue
  Scenario: Request Mamitour
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin create request package "3 Bulan" mamitour for "087133998156"
    Then admin verify "UNPAID" transaction for "087133998156"

  @mamitourAdmin @continue
  Scenario: Verifed Mamitour
    When admin paid all unpaid transaction for "087133998156"
    Then admin verify "PAID" transaction for "087133998156"

  @mamitourAdmin
  Scenario: List Tabel Mamitour
    Then admin verify table header row is displayed with name:
      | Id                 |
      | Owner Name         |
      | Owner Phone Number |
      | Request Date       |
      | MamiTour Plan      |
      | Total Payment      |
      | Status Payment     |
      | Paid At            |
      | Action             |