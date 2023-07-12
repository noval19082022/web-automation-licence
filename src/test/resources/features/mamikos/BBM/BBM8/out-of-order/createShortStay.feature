@arac @pms @TEST_BBM-3726 @BBM8
Feature: Create OOO "Short Stay" Type

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
      | 1           | 16         |
    Then Admin can not see out of order on:
      | room number | start date |
      | 1           | 16         |

#  @TEST_BBM-3726
  Scenario: Create OOO "Short Stay"
    When Admin create OOO on:
      | room number | 1          |
      | type        | Short Stay |
      | start date  | 16         |
      | end date    | 20         |
    Then Admin can see out of order on:
      | room number | start date |
      | 1           | 16         |