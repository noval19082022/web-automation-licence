@ss @ss2 @pms @filterTipeTransfer

Feature: Filter Tipe Transfer

  @TEST_SS-8575
  Scenario: Filter by Tipe Transfer Bulanan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin filter Tipe Transfer "Transfer Bulanan"
    Then display property list with Tipe Transfer "Transfer Bulanan"
    #search property monthly
    When admin search property by name "Khusus Automation"
    Then display property list name "Kost Apik Khusus Automation PMAN Halmahera Utara"
    #search property weekly
    When admin search property by name "Senin Wage"
    Then empty state in Homepage menu is displayed

  @TEST_SS-8576
  Scenario: Filter by Tipe Transfer Mingguan
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin filter Tipe Transfer "Transfer Mingguan"
    Then display property list with Tipe Transfer "Transfer Mingguan"
    #search property monthly
    When admin search property by name "Khusus Automation"
    Then empty state in Homepage menu is displayed
    #search property weekly
    When admin search property by name "Senin Wage"
    Then display property list name "Kost Singgahsini Senin Wage Mataram"
