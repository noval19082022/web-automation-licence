@regression @LIMO3 @listing-monetization @reviewed
Feature: PPRS - Check statistic section when owner not have property active

  @TEST_LIMO-281 @TEST_LIMO-280
  Scenario Outline: [WEB][Owner Dashboard] Owner Dashboard when Owner doesn't have an active property And Statistic Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | <ownerPhone> | <password> |
    Then owner can see onboarding card on owner dashboard
    And owner can see onboarding title "<onboardingTitle>"
    And owner can see onboarding description "<onboardingDescription>"
    And owner navigates to statistic page
    And owner can see title "Data Properti Belum Ada" at section statistic
    And owner can see desc "Anda belum punya properti yang terverifikasi. Data properti terverifikasi akan muncul di sini." at section statistic
    Examples:
      | ownerPhone   | password  | onboardingTitle                       | onboardingDescription                                                                    |
      | 0876623622   | qwerty123 | 👋🏼  Selamat datang, Rega Non Property | Pasang iklan pertama Anda agar bisa segera ditemukan calon penyewa!                     |
      | 0876623687   | 12345678  | ⚠️ Iklan Gagal Diverifikasi           | Cek alasan gagal dan lekas perbaiki iklan Anda agar dapat tayang.                       |
      | 081333333335 | 12345678  | ✋ Iklan Anda Belum Lengkap            | Selesaikan iklan Anda agar bisa segera tampil di Mamikos dan dilihat calon penyewa.     |

  @TEST_LIMO-296 @apartementonlyPPRS @continue
  Scenario: [WEB][Owner Dashboard]Statistic Section on Owner Dashboard when Owner only have apartment and no kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password |
      | 085687543611 | 12345678 |
    Then owner cannot see onboarding card on owner dashboard

  @TEST_LIMO-279 @apartementonlyPPRS
  Scenario: [WEB][Laporan Statistic]Statistic Section when Owner only have apartment and no kost
    When owner navigates to statistic page
    Then owner can see title for apartement  "Statistik Apartemen Belum Ada" at section statistic
    And owner can see desc for apartment "Mohon maaf, saat ini data performa untuk apartemen belum dapat ditampilkan. Tunggu update dari kami selanjutnya, ya." at section statistic