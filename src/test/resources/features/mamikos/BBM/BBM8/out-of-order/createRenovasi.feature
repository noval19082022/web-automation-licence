@arac @pms @TEST_BBM-3724 @BBM8
Feature: Create OOO "Renovasi" Type

  @continue
  Scenario: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And admin go to room allotment page
    And admin search "Kost Singgahsini Auto Listing"
    And admin delete OOO on:
      | room number | start date |
      | 1           | 6          |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 6          |

#  @TEST_BBM-3724
  Scenario: Create OOO "Renovasi"
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type        | Renovasi   |
      | start date  | 6          |
      | end date    | 10         |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 6          |