@regression @LIMO1 @LIMO1-staging @essentialTest3
Feature: GP Crosseling

  @TEST_LIMO-287
  Scenario: Ubah package GP after select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 085951394565 | 0          | qwerty123 |
    And user click "Daftar" button
    And user choose Goldplus package 1
    #Scenario: detail list saldo MamiAds 4887
    Then user view detail list saldo MamiAds
      | saldo     | cashback  | disc | salePrice   | discPriceMamiAds | saving          |
      | 1.500.000 | + 150.000 | 10%  | Rp1.350.000 | 1.500.000        | Hemat Rp300.000 |
      | 6.000     | + 600     |      | Rp6.000     |                  | Hemat Rp600     |
      | 30.000    | + 3.000   | 10%  | Rp27.000    |  30.000          | Hemat Rp6.000   |
    #Scenario: : lihat lebih banyak 4888
    When user click "Lihat lebih banyak"
    Then user view detail list saldo MamiAds
      | saldo     | cashback  | disc | salePrice   | discPriceMamiAds | saving            |
      | 1.500.000 | + 150.000 | 10%  | Rp1.350.000 | 1.500.000        | Hemat Rp300.000   |
      | 6.000     | + 600     |      | Rp6.000     |                  | Hemat Rp600       |
      | 30.000    | + 3.000   | 10%  | Rp27.000    | 30.000           | Hemat Rp6.000     |
      | 50.000    | + 5.000   |      | Rp50.000    |                  | Hemat Rp5.000     |
      | 80.000    | + 8.000   | 6%   | Rp75.000    | 80.000           | Hemat Rp13.000    |
      | 205.000   | + 20.500  |      | Rp205.000   |                  | Hemat Rp20.500    |
      | 300.000   | + 30.000  | 8%   | Rp276.000   | 300.000          | Hemat Rp54.000    |
      | 850.000   | + 85.000  |      | Rp850.000   |                  | Hemat Rp85.000    |
      | 1.000.000 | + 100.000 | 7%   | Rp925.000   | 1.000.000        | Hemat Rp175.000   |
      | 5.000.000 | + 500.000 | 10%  | Rp4.500.000 | 5.000.000        | Hemat Rp1.000.000 |
    When user click "Tutup"
    And user choose saldo "Rp1.350.000" on GoldPlus section

     #Scenario: rincian pembayaran while saldo MamiAds and GoldPlus 4886
    Then user verify the "Saldo MamiAds 1.500.000" and the price is "Rp1.350.000" already "choosen" on Rincian Pembayaran
#Scenario: ubah package GP after choose MamiAds 4882
    When user click on ubah package gold plus button
    And user choose Goldplus package 2
    And user verify the "Saldo MamiAds 1.500.000" and the price is "Rp1.350.000" already "choosen" on Rincian Pembayaran

  @TEST_LIMO-288
  Scenario: Cancel select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 085720962105 | 0          | qwerty123 |
    And user click "Daftar" button
    And user choose Goldplus package 1
    # scenario ubah package before select saldo mamiads (MA-4881)
    When user click on ubah package gold plus button
    And user choose Goldplus package 2
    And user choose saldo "Rp27.000" on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "choosen" on Rincian Pembayaran
    # scenario cancel saldo mamiads (MA-4885)
    And user unchoose saldo on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "removed" on Rincian Pembayaran

  @TEST_LIMO-223 @continue @gpCrossPaid
    Scenario: [Owner dashboard][Crosseling GP and MamiAds]To make sure saldo mamiads DIDN'T appear on Riwayat Saldo Mamiads while status GP = menunggu pembayaran
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 089966331122 | 0          | 12345678 |
    And user click "Daftar" button
    And user choose Goldplus package 1
    And user choose saldo "Rp27.000" on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "choosen" on Rincian Pembayaran
    And owner click bayar sekarang on detail tagihan page goldplus
    Then owner validate payment for "GoldPlus 1 periode 4 Bulan" have "Saldo MamiAds 30.000" and have "Biaya Transaksi" before choose payment method
    And user navigate to mamiads history page
    And user will see title and message on Dalam Proses tab

  @TEST_LIMO-226 @continue @gpCrossPaid
  Scenario: [Goldplus ][Crosseling GP and MamiAds]Success buy cross-selling GP and mamiads
    And owner navigates to owner dashboard
    Then validate that owner have "Menunggu Pembayaran"
    And owner wants to paid GP crosseling by click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then payment owner success using ovo as payment method
    And user navigate to mamiads history page
    And user click "Selesai"
    And validate status transaction mamiads is "Lunas" with price "Rp27.000" saldo "30.000"

    @terimanateGP @gpCrossPaid
  Scenario: Terminate GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to terminate Goldplus for owner with phone number "089966331122"