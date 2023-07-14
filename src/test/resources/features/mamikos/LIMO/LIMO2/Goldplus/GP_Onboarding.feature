@LIMO2 @regression @gp-onboarding @owner
Feature: Owner Dashboard GP-ONboarding

  @continue
  Scenario: [Web Owner][GP-Onboarding] Owner visit “Panduan Fitur di GoldPlus”
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 087133998156 | 0          | qwerty123 |
    And owner go to panduan gold plus page
    Then owner will see that the text "Naikkan Posisi Iklan Properti dengan MamiAds" is displayed
    Then owner will see that the text "Dengan Saldo MamiAds, iklan Anda bisa mendapat lebih banyak pengunjung." is displayed
    Then owner will see that the text "Dapatkan keuntungan MamiAds sebagai berikut:" is displayed
    Then owner will see that the text "Properti Tampil Lebih di Atas" is displayed
    * owner will see that the text "Cukup beli saldo MamiAds dan pilih properti yang ingin diiklankan di posisi lebih atas pada hasil pencarian." is displayed
    Then owner will see that the text "Properti Tampil di Banyak Tempat" is displayed
    * owner will see that the text "Terima poin cukup dengan beraktivitas di Mamikos. Bagi pengguna GoldPlus, poin yang didapat akan lebih banyak." is displayed
    Then owner will see that the text "Tentukan Anggaran Harian" is displayed
    * owner will see that the text "Anda dapat membatasi pemakaian saldo MamiAds per harinya sesuai kebutuhan Anda." is displayed
    Then owner will see that the text "Pantau Performa Iklan" is displayed
    * owner will see that the text "Lewat Statistik Iklan, Anda dapat melihat perkembangan iklan Properti Anda." is displayed

  @continue
  Scenario: [Web Owner][GP-Onboarding] Swiper Left/Previous Button Should Be Disabled
    Then owner can see swiper left or previous button is disabled

  @continue
  Scenario Outline: [Web Owner][GP-Onboarding] Check Panduan Gold Plus Swiper Functionality Left To Right
    Then owner can see swipper number <number> is selected
    Then owner can see selected swiper with title <number>
    Then owner can see swiper text body is "<text_body>"
    When owner click on next button to go to slide number <number>
    Examples:
      | number | text_body                                 |
      | 1      | Kunjungi Menu MamiAds                     |
      | 2      | Beli Saldo MamiAds                        |
      | 3      | Pilih Iklan Properti Anda                 |
      | 4      | Pilih Jenis Anggaran                      |
      | 5      | Anggaran Aktif Setiap Hari                |
      | 6      | Kendalikan Pengeluaran Saldo              |
      | 7      | Pantau Performa di Statistik Iklan        |

  @continue
  Scenario: [Web Owner][GP-Onboarding] Swiper Right/Next Button Should Be Disabled
      Then owner can see swiper right or next button is disabled

  @continue
  Scenario Outline: [Web Owner][GP-Onboarding] Check Panduan Gold Plus Swipper Functionality Right To Left
    Then owner can see swipper number <number> is selected
    Then owner can see selected swiper with title <number>
    Then owner can see swiper text body is "<text_body>"
    When owner click on previous button to go to slide number <number>
    Examples:
      | number | text_body                                 |
      | 7      | Pantau Performa di Statistik Iklan        |
      | 6      | Kendalikan Pengeluaran Saldo              |
      | 5      | Anggaran Aktif Setiap Hari                |
      | 4      | Pilih Jenis Anggaran                      |
      | 3      | Pilih Iklan Properti Anda                 |
      | 2      | Beli Saldo MamiAds                        |
      | 1      | Kunjungi Menu MamiAds                     |