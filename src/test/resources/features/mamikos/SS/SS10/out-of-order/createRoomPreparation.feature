@arac @pms @TEST_SS-3382 @SS8
Feature: Create OOO "Room Preparation" Type

  @TEST_SS-3382
  @continue
  Scenario: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
#    And admin search "Kost Singgahsini Auto Listing"
    And admin delete OOO on:
      | room number | start date |
      | 1           | 2          |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 2          |

#  @TEST_COOP-1093
  Scenario: Create OOO "Room Preparation"
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type       | Room Preparation |
      | start date | 2                |
      | end date   | 5                |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 2          |