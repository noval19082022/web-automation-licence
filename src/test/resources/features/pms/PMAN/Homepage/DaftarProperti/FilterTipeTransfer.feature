@ss @pman2 @pms @filterTipeTransfer

Feature: Filter Tipe Transfer

  @TEST_SS-8575
  Scenario: Filter by Tipe Transfer Bulanan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin filter Tipe Transfer "Transfer Bulanan"
    Then display property list with Tipe Transfer "Transfer Bulanan"

  @TEST_SS-8576
  Scenario: Filter by Tipe Transfer Mingguan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin filter Tipe Transfer "Transfer Mingguan"
    Then display property list with Tipe Transfer "Transfer Mingguan"