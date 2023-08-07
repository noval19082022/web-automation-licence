@arac @pms @TEST_BBM-3726 @BBM8
Feature: Create OOO "Short Stay" Type

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
      | 1           | 16         |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 16         |

#  @TEST_BBM-3726
  Scenario: Create OOO "Short Stay"
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type        | Short Stay |
      | start date  | 16         |
      | end date    | 20         |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 16         |