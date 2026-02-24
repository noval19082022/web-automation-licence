@arac @pms @SS8
Feature: Create OOO "Lainnya" Type With/Without Note

  Background: Delete OOO From Room Allotment Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin delete OOO on:
      | room number | start date |
      | 3           | 21         |
    Then admin can not see out of order on:
      | room number | start date |
      | 3           | 21         |

  @TEST_SS-3377
  Scenario: Create OOO "Lainnya" with note
    When admin set out of order on room "3"
    And admin fill OOO data with:
      | type       | Lainnya   |
      | note       | WC Mampet |
      | start date | 21        |
      | end date   | 25        |
    Then admin can see out of order on:
      | room number | start date |
      | 3           | 21         |

  @TEST_SS-3376
  Scenario: Create OOO "Lainnya" without note
    When admin set out of order on room "3"
    And admin fill OOO data with:
      | type       | Lainnya |
      | start date | 21      |
      | end date   | 25      |
    Then admin can see that save button is disable