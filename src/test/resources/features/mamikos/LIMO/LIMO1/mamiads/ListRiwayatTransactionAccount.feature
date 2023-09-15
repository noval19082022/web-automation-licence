@regression @LIMO1
Feature: List Riwayat Transaction Account

  @TEST_LIMO-276
  Scenario: List Riwayat Transaction Account - Empty
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 085720962106  | qwerty123 |
    And user click on Saldo MamiAds at owner dashboard
    And user click Coba Sekarang on MamiAds landing page
    And user close mamiads onboarding popup
    And user see title "Anda Belum Punya Properti" with message "Daftarkan dulu properti Anda di Mamikos untuk bisa memakai MamiAds."
    And user click "Riwayat"
    And user see title "Belum Ada Transaksi" with message "Transaksi yang masih dalam proses akan muncul di halaman ini." on page "dalam proses"
    And user click "Selesai"
    Then user see title "Belum Ada Transaksi" with message "Transaksi yang sudah selesai akan muncul di halaman ini." on page "selesai"

  @TEST_LIMO-59
  Scenario: To make sure red counter badge if owner have on going transaction
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 083176408449  | 0895365624343 | qwerty123 |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    And user verify count of riwayat before beli saldo
    And user click "Beli Saldo"
    And user choose saldo MamiAds "Rp6.000"
    And user see title "Detail Tagihan"
    And user click "Bayar Sekarang"
    And owner navigates to "/mamiads"
    Then user verify count of riwayat added 1



