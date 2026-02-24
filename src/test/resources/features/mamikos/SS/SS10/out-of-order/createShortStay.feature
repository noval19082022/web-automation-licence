@arac @pms @TEST_SS-3378 @SS8
Feature: Create OOO "Short Stay" Type

  @continue
  Scenario: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin delete OOO on:
      | room number | start date |
      | 1           | 16         |
    Then admin can not see out of order on:
      | room number | start date |
      | 1           | 16         |

#  @TEST_COOP-1074
  Scenario: Create OOO "Short Stay"
    When admin set out of order on room "1"
    And admin fill OOO data with:
      | type       | Short Stay |
      | start date | 16         |
      | end date   | 20         |
    Then admin can see out of order on:
      | room number | start date |
      | 1           | 16         |