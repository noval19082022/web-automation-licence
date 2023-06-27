@arac @pms @TEST_BBM-3723
Feature: Create OOO "Room Preparation" Type

  @TEST_BBM-3738
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
      | 1           | 1          |
    Then Admin can not see out of order on:
      | room number | start date |
      | 1           | 1          |

#  @TEST_BBM-3723
  Scenario: Create OOO "Room Preparation"
    When Admin create OOO on:
      | room number | 1                |
      | type        | Room Preparation |
      | start date  | 1                |
      | end date    | 5                |
    Then Admin can see out of order on:
      | room number | start date |
      | 1           | 1          |