@pms @SS8
Feature: OOO Reason Options

  @TEST_SS-5560
  Scenario Outline: [PMS][Calender View] Check Kategori option in order at form edit reason in calendar view
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin set out of order on room "4"
    And admin click on dropdown type
    Then admin validate this "<type>" on out of order type
    Examples:
      | type             |
      | Room preparation |
      | Renovasi         |
      | Short Stay       |
      | Undertable       |
      | Dipakai Owner    |
      | Internal Case    |
      | Terminate        |
      | Lainnya          |

  @continue
  Scenario: delete ooo
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to room allotment page "Kost Singgahsini Ersa Tobelo Halmahera Utara"
    And admin delete OOO on:
      | room number | start date |
      | 4           | 11         |
    Then admin can not see out of order on:
      | room number | start date |
      | 4           | 11         |

  @TEST_SS-5561
  Scenario: [PMS][Calender View] Verify update kategori OOO when admin success change kategori
    When admin set out of order on room "4"
    And admin fill OOO data with:
      | type       | Dipakai Owner |
      | start date | 11            |
      | end date   | 15            |
    Then admin can see out of order on:
      | room number | start date |
      | 4           | 11         |

