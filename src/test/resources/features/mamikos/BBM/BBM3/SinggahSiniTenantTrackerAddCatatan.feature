@regression @BBM3 @tenantTracker

Feature: SinggahSini - Tenant Tracker - Add Catatan

  @TEST_BBM-564 @continue
  Scenario: Add Catatan on Detail Penyewa
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to tenant communication menu
    And user choose "Nama Penyewa" and input "adiSinggahSini" in the search field on main page
    And user click search button on main page filter
    And user fill "prioritaskan" in note field
    Then user verify search result on main page bse contains Prioritaskan

  @TEST_BBM-563
  Scenario: Delete Note
    When user click note prioritaskan
    And user clear note field
    Then user verify search result on main page bse contains Tambah Catatan
