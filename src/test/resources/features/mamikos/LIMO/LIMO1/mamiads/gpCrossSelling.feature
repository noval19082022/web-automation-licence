@regression @LIMO1 @LIMO1-staging @essentialTest3 @gpCrosselling @DONEMIGRATINGTONEWBOARD
Feature: GP Crosseling

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3351
  Scenario: Ubah package GP after select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And user click daftar GP button
    And user choose Goldplus package 1

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3355
  Scenario: Detail list saldo
    Then user view detail list saldo MamiAds
      | saldo  | cashback | disc | salePrice | discPriceMamiAds | saving        |
      | 10.000 | + 0      |      | Rp10.000  | 10.000           | Hemat Rp0     |
      | 30.000 | + 3.000  | 10%  | Rp27.000  | 30.000           | Hemat Rp6.000 |
      | 50.000 | + 5.000  |      | Rp50.000  | 30.000           | Hemat Rp5.000 |

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3358
  Scenario: : Lihat lebih banyak
    When user click "Lihat lebih banyak"
    Then user view detail list saldo MamiAds
      | saldo  | cashback | disc | salePrice | discPriceMamiAds | saving         |
      | 10.000 | + 0      |      | Rp10.000  | 10.000           | Hemat Rp0      |
      | 30.000 | + 3.000  | 10%  | Rp27.000  | 30.000           | Hemat Rp6.000  |
      | 50.000 | + 5.000  |      | Rp50.000  |                  | Hemat Rp5.000  |
      | 75.000 | + 7.500  | 6%   | Rp75.000  | 80.000           | Hemat Rp12.500 |
      | 80.000 | + 8.000  |      | Rp80.000  |                  | Hemat Rp8.000  |

    When user click "Tutup"
    And user choose saldo "Rp10.000" on GoldPlus section

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3350
  Scenario: Rincian pembayaran while saldo MamiAds and GoldPlus
    Then user verify the "Saldo MamiAds 10.000" and the price is "Rp10.000" already "choosen" on Rincian Pembayaran

  @mamiads  @gpCrossSelling @TEST_LIMO-3352
  Scenario: Ubah package GP after choose MamiAds
    When user click on ubah package gold plus button
    And user choose Goldplus package 2
    Then user verify the "Saldo MamiAds 10.000" and the price is "Rp10.000" already "choosen" on Rincian Pembayaran

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3354
  Scenario: Cancel select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085720962105 | 0          | qwerty123 |
    And user click daftar GP button
    And user choose Goldplus package 1

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3357
  Scenario: Ubah package before select saldo mamiads
    When user click on ubah package gold plus button
    And user choose Goldplus package 2
    And user choose saldo "Rp27.000" on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "choosen" on Rincian Pembayaran

  @mamiads  @gpCrossSelling @TEST_LIMO-3349
  Scenario: Cancel saldo mamiads
    And user unchoose saldo on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "removed" on Rincian Pembayaran

  @continue @gpCrossPaid @TEST_LIMO-1393
  Scenario: [Owner dashboard][Crosseling GP and MamiAds]To make sure saldo mamiads DIDN'T appear on Riwayat Saldo Mamiads while status GP = menunggu pembayaran
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 089966331122 | 0          | 12345678 |
    And user click daftar GP button
    And user choose Goldplus package 1
    And user choose saldo "Rp27.000" on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "choosen" on Rincian Pembayaran
    And owner click bayar sekarang on detail tagihan page goldplus
    Then owner validate payment for goldplus package have "Saldo MamiAds 30.000 + GoldPlus 1" and have "Biaya Transaksi" before choose payment method
    And user navigate to mamiads history page
    And user will see that the text "Saldo MamiAds 30.000 + GoldPlus 1" is displayed

  @continue @gpCrossPaid @TEST_LIMO-3353
  Scenario: [Goldplus ][Crosseling GP and MamiAds]Success buy cross-selling GP and mamiads
    And owner navigates to owner dashboard
    Then validate that owner have "Menunggu Pembayaran"
    And owner wants to paid GP crosseling by click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then payment owner success using ovo as payment method
    And user navigate to mamiads history page
    And user click "Selesai"
    And validate status transaction mamiads is "Lunas" with price "Rp109.500" saldo "Saldo MamiAds 30.000 + GoldPlus 1 (reg#1m) (1 Bulan)"

  @terminate @gpCrossPaid @TEST_LIMO-3352
  Scenario: Terminate GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to terminate Goldplus for owner with phone number "089966331122"