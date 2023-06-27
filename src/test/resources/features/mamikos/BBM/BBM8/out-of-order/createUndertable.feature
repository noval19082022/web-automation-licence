@arac @pms @TEST_BBM-3725
Feature: Create OOO "Undertable" Type

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
      | 1           | 11         |
    Then Admin can not see out of order on:
      | room number | start date |
      | 1           | 11         |

#  @TEST_BBM-3725
  Scenario: Create OOO "Undertable"
    When Admin create OOO on:
      | room number | 1          |
      | type        | Undertable |
      | start date  | 11         |
      | end date    | 15         |
    Then Admin can see out of order on:
      | room number | start date |
      | 1           | 11         |