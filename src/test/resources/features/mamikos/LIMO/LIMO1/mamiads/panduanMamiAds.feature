@regression @LIMO1 @DONEMIGRATINGTONEWBOARD
Feature: Panduan MamiAds

  @TEST_LIMO-3377 @continue
  Scenario: Open Owner Non GP learn about MamiAds from "MamiAds" screen
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0819999999934 | 0          | qwerty123 |
    When user navigates to mamiads dashboard
    And user will see that the text "Naikkan Posisi Iklan Properti dengan MamiAds" is displayed
    And user will see that the text "Dengan Saldo MamiAds, iklan Anda bisa mendapat lebih banyak pengunjung." is displayed
    And user will see that the text "Dapatkan keuntungan MamiAds sebagai berikut:" is displayed
    And user will see that the text "Properti Tampil Lebih di Atas" is displayed
    And user will see that the text "Cukup beli saldo MamiAds dan pilih properti yang ingin diiklankan di posisi lebih atas pada hasil pencarian." is displayed
    And user will see that the text "Properti Tampil di Banyak Tempat" is displayed
    And user will see that the text "Iklan tayang di berbagai titik strategis di aplikasi dan web Mamikos." is displayed
    And user will see that the text "Tentukan Anggaran Harian" is displayed
    And user will see that the text "Anda dapat membatasi pemakaian saldo MamiAds per harinya sesuai kebutuhan Anda." is displayed
    And user will see that the text "Pantau Performa Iklan" is displayed
    And user will see that the text "Lewat Statistik Iklan, Anda dapat melihat perkembangan iklan Properti Anda." is displayed
    And user close mamiads onboarding popup
    And user click "Pelajari di Sini"
    Then user redirected to guides page mamiAds

  @TEST_LIMO-3373
  Scenario: [Mamiads dashboard][Panduan Mamiads]: View "Panduan Mamiads" screen
    And user will see that the text "Naikkan Posisi Iklan Properti dengan MamiAds" is displayed

  @TEST_LIMO-3375 @continue
  Scenario: Open Owner GP learn about MamiAds from "GP onboard" screen
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And owner go to panduan gold plus page
    Then user redirected to guides page mamiAds from GP
    And user click "Naikkan Iklan Anda"
    And user will see that the text "Naikkan Posisi Iklan Properti dengan MamiAds" is displayed

  @TEST_LIMO-3374 @continue
  Scenario:  Back to "MamiAds" screen by tap the "Coba Sekarang" button MA-4689
    And user click "Coba Sekarang"
    Then user redirected to mamiads page

  @TEST_LIMO-3376
  Scenario: Back to "MamiAds" screen by tap the back button 4690
    And user close mamiads onboarding popup
    And user click "Pelajari di Sini"
    And tap back button on panduan Mamiads.
    Then user redirected to mamiads page