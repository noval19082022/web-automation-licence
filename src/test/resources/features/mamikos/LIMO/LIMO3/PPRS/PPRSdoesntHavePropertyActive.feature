@regression @LIMO3 @listing-monetization
Feature: PPRS - Check statistic section when doesnt have property active


  @TEST_LIMO-4700
  Scenario Outline: [WEB][Owner Dashboard] Statistic Section on Owner Dashboard when Owner doesn’t have an active property
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    Then owner can see section Laporan Statistik when doesnt have property active
    And owner can see title "Data Properti Belum Ada" at section statistic
    And owner can see desc "Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan muncul di sini." at section statistic
    And owner should successfully log out
    Examples:
    #owner doesnt have property
    #owner only have 1 kost non active
    #owner only have kost draft
      | ownerPhone   | password  |
      | 0876623622   | qwerty123 |
      | 0876623687   | 12345678  |
      | 081333333335 | 12345678  |