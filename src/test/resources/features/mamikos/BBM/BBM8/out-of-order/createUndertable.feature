@arac @pms @TEST_COOP-1077 @BBM8
Feature: Create OOO "Undertable" Type

  @continue
  Scenario: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email                 | password    |
      | dhiandra@mamikos.com  | dh14ndr4321 |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin delete OOO on:
      | room number | start date |
      | 1           | 11         |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 11         |

#  @TEST_COOP-1077
  Scenario: Create OOO "Undertable"
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type        | Undertable |
      | start date  | 11         |
      | end date    | 15         |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 11         |