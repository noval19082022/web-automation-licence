@regression @LIMO3 @listing-monetization @reviewed @pprs
Feature: PPRS - Check statistic section when owner not have property active

  @TEST_LIMO-281 @TEST_LIMO-280
  Scenario Outline: [WEB][Owner Dashboard] Owner Dashboard when Owner doesn't have an active property And Statistic Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    And owner accsess statistic page
#    Then owner can see section Laporan Statistik when doesnt have property active
    And owner can see title "Data Properti Belum Ada" at section statistic
    And owner can see desc "Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan muncul di sini." at section statistic
    Examples:
    #owner doesnt have property
    #owner only have 1 kost non active
    #owner only have kost draft
      | ownerPhone   | password  |
      | 0876623622   | qwerty123 |
      | 0876623687   | 12345678  |
      | 081333333335 | 12345678  |

  @TEST_LIMO-280
  Scenario Outline: [WEB][Statistic Page] Statistic Section when Owner doesn’t have an active property
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    And owner accsess statistic page
#    Then owner can see Laporan Statistik page when doesnt have property active
    And owner will see that the text is displayed
      | Data Properti Belum Ada                                                                        |
      | Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan muncul di sini. |
#    And owner can see title "Data Properti Belum Ada" at section statistic
#    And owner can see desc "Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan muncul di sini." at section statistic
    And owner should successfully log out
    Examples:
    #owner doesnt have property
    #owner only have 1 kost non active
    #owner only have kost draft
      | ownerPhone   | password  |
      | 0876623622   | qwerty123 |
      | 0876623687   | 12345678  |
      | 081333333335 | 12345678  |

  @TEST_LIMO-296 @apartementonlyPPRS @continue
  Scenario: [WEB][Owner Dashboard]Statistic Section on Owner Dashboard when Owner only have apartment and no kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password |
      | 085687543611 | 12345678 |
    And owner accsess statistic page
#    Then owner can see section Laporan Statistik when doesnt have property active
    And owner will see that the text is displayed
      | Statistik Apartemen Belum Ada                                                                                        |
      | Mohon maaf, saat ini data performa untuk apartemen belum dapat ditampilkan. Tunggu update dari kami selanjutnya, ya. |
#    And owner can see title for apartement  "Statistik Apartemen Belum Ada" at section statistic
#    And owner can see desc for apartment "Mohon maaf, saat ini data performa untuk apartemen belum dapat ditampilkan. Tunggu update dari kami selanjutnya, ya." at section statistic

  @TEST_LIMO-279 @apartementonlyPPRS
  Scenario: [WEB][Laporan Statistic]Statistic Section when Owner only have apartment and no kost
    When owner accsess statistic page
    And owner can see Laporan Statistik page when doesnt have property active
    Then owner can see title for apartement  "Statistik Apartemen Belum Ada" at section statistic
    And owner can see desc for apartment "Mohon maaf, saat ini data performa untuk apartemen belum dapat ditampilkan. Tunggu update dari kami selanjutnya, ya." at section statistic
