@regression @tenantTracker @BBM3

Feature: SinggahSini - Tenant Tracker - Main Page

  @TEST_BBM-551 @continue
  Scenario: Pagination Functionality
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to tenant communication menu
    Then user see pagination menu on Detail Tenant is displayed
    When user click pagination number "0"
    Then user see display data row from 20 riwayat

  @TEST_BBM-554
  Scenario: Column Name Complete
    When admin go to tenant communication menu
    Then user see at Tenant Main Page Column contains
      | Head Table              |
      | Profil Penyewa          |
      | Nama Properti           |
      | Fase                    |
      | Status                  |
      | Tanggal Status          |
      | Catatan                 |
      | Owner                   |
      | Action                  |