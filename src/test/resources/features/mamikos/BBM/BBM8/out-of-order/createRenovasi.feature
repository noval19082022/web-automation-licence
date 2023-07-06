@arac @pms @TEST_BBM-3724 @BBM8
Feature: Create OOO "Renovasi" Type

  @continue
  Scenario: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And Admin go to room allotment page
    And Admin search "Kost Singgahsini Auto Listing"
    And Admin delete OOO on:
      | room number | start date |
      | 1           | 6          |
    Then Admin can not see out of order on:
      | room number | start date |
      | 1           | 6          |

#  @TEST_BBM-3724
  Scenario: Create OOO "Renovasi"
    When Admin create OOO on:
      | room number | 1          |
      | type        | Renovasi   |
      | start date  | 6          |
      | end date    | 10         |
    Then Admin can see out of order on:
      | room number | start date |
      | 1           | 6          |