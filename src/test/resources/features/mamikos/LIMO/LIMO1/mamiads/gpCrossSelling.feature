@regression @LIMO1 @LIMO1-staging @essentialTest3 @gpCrosselling
Feature: GP Cross-Selling

  #terminate belum jalan as expected
  @terminate @gpCrossPaid @TEST_LIMO-3352
  Scenario: Terminate GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to terminate Goldplus for owner with phone number "085951394565"

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3351
  Scenario: Ubah package GP after select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085951394565 | 0          | qwerty123 |
    And user click daftar GP button
    And owner choose Goldplus package 1
    And owner click bayar sekarang on detail tagihan page goldplus

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3355
  Scenario: Detail list saldo
    Then user view detail list saldo MamiAds
      """
      - paragraph: Mau tambah Saldo MamiAds?
      - paragraph: Agar posisi kos Anda makin naik! Ada bonus saldo untuk pengguna GoldPlus.
      - text: Favorit
      - paragraph: 150 ribu
      - paragraph: Rp150.000
      - paragraph: 10 ribu
      - paragraph: 88%
      - paragraph: "8.000"
      - paragraph: Rp1.000
      - paragraph: Hemat Rp7.000
      - paragraph: 30 ribu
      - paragraph: + 3.000
      - paragraph: 10%
      - paragraph: "30.000"
      - paragraph: Rp27.000
      - paragraph: Hemat Rp6.000
      - paragraph: Lihat lebih banyak
      """

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3358
  Scenario: : Lihat lebih banyak
    When user click "Lihat lebih banyak"
    Then user view detail list saldo MamiAds
      """
- paragraph: Mau tambah Saldo MamiAds?
- paragraph: Agar posisi kos Anda makin naik! Ada bonus saldo untuk pengguna GoldPlus.
- text: Favorit
- paragraph: 150 ribu
- paragraph: Rp150.000
- paragraph: 10 ribu
- paragraph: 88%
- paragraph: "8.000"
- paragraph: Rp1.000
- paragraph: Hemat Rp7.000
- paragraph: 30 ribu
- paragraph: + 3.000
- paragraph: 10%
- paragraph: "30.000"
- paragraph: Rp27.000
- paragraph: Hemat Rp6.000
- paragraph: 75 ribu
- paragraph: + 7.500
- paragraph: 7%
- paragraph: "80.000"
- paragraph: Rp75.000
- paragraph: Hemat Rp12.500
- paragraph: 80 ribu
- paragraph: + 8.000
- paragraph: Rp80.000
- paragraph: Hemat Rp8.000
- paragraph: 300 ribu
- paragraph: + 24.000
- paragraph: 8%
- paragraph: "300.000"
- paragraph: Rp276.000
- paragraph: Hemat Rp48.000
- paragraph: 850 ribu
- paragraph: + 85.000
- paragraph: Rp850.000
- paragraph: Hemat Rp85.000
- paragraph: 1 juta
- paragraph: + 100.000
- paragraph: 15%
- paragraph: 1.000.000
- paragraph: Rp850.000
- paragraph: Hemat Rp250.000
- paragraph: 10 juta
- paragraph: + 1.000.000
- paragraph: 30%
- paragraph: 10.000.000
- paragraph: Rp7.000.000
- paragraph: Hemat Rp4.000.000
- paragraph: 20 juta
- paragraph: + 4.000.000
- paragraph: 50%
- paragraph: 20.000.000
- paragraph: Rp10.000.000
- paragraph: Hemat Rp14.000.000
- paragraph: Tutup
      """
    When user click "Tutup"
    And user choose saldo "10 ribu" on GoldPlus section

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3350
  Scenario: Rincian pembayaran while saldo MamiAds and GoldPlus
    Then user verify saldo MamiAds is choosen on Rincian Pembayaran
      """
      - paragraph: Rincian Pembayaran
      - text: GoldPlus 1 periode 1 Bulan
      - paragraph: + Gratis MamiAds 120.000
      - paragraph: Rp79.000
      - text: Saldo MamiAds 8.000
      - paragraph: Rp1.000
      """
    And user verify Total Pembayaran
      """
      - paragraph: Total Pembayaran
      - paragraph: Rp80.000
      """

  @mamiads  @gpCrossSelling @TEST_LIMO-3352
  Scenario: Ubah package GP after choose MamiAds
    When user click on ubah package gold plus button
    And owner choose Goldplus package 2
    And owner click bayar sekarang on detail tagihan page goldplus
    Then user verify saldo MamiAds is choosen on Rincian Pembayaran
      """
      - paragraph: Rincian Pembayaran
      - text: GoldPlus 2 periode 1 Bulan
      - paragraph: + Gratis MamiAds 100.000
      - paragraph: Rp145.000
      - text: Saldo MamiAds 8.000
      - paragraph: Rp1.000
      """
    And user verify Total Pembayaran
      """
      - paragraph: Total Pembayaran
      - paragraph: Rp146.000
      """

  @mamiads @gpCrossSelling @continue @TEST_LIMO-3354
  Scenario: Cancel select saldo mamiads
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 085720962105 | 0          | qwerty123 |
    And user click daftar GP button
    And user click "Ganti Paket" button
    And owner choose Goldplus package 1

  @mamiads  @gpCrossSelling @continue @TEST_LIMO-3357
  Scenario: Ubah package before select saldo mamiads
    And owner click bayar sekarang on detail tagihan page goldplus
    When user click on ubah package gold plus button
    And owner choose periode goldplus 2
    And user choose saldo "30 ribu" on GoldPlus section
    Then user verify saldo MamiAds is choosen on Rincian Pembayaran
      """
      - paragraph: Rincian Pembayaran
      - text: GoldPlus 2 periode 4 Bulan
      - paragraph: + Gratis MamiAds 40.000
      - paragraph: Rp320.000
      - text: Saldo MamiAds 30.000
      - paragraph: Rp27.000
      """
    And user verify Total Pembayaran
      """
      - paragraph: Total Pembayaran
      - paragraph: Rp347.000
      """

#  @mamiads  @gpCrossSelling @TEST_LIMO-3349
  Scenario: Cancel saldo mamiads
    And user unchoose saldo on GoldPlus section
    Then user verify the "Saldo MamiAds 30.000" and the price is "Rp27.000" already "removed" on Rincian Pembayaran

  @resetGP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "089966331122"

  @continue @gpCrossPaid @TEST_LIMO-1393
  Scenario: [Owner dashboard][Crosseling GP and MamiAds]To make sure saldo mamiads DIDN'T appear on Riwayat Saldo Mamiads while status GP = menunggu pembayaran
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password |
      | 089966331122 | 0          | 12345678 |
    #seharusnya tidak click tombol yang ini
    And user click daftar GP button
    And user click "Pilih Paket GoldPlus" button
    And owner choose Goldplus package 1
    And user choose saldo "Rp79.000" on GoldPlus section
    And owner click bayar sekarang on detail tagihan page goldplus
    Then user verify saldo MamiAds is choosen on Rincian Pembayaran
      """
      - paragraph: Rincian Pembayaran
      - text: GoldPlus 1 periode 1 Bulan
      - paragraph: + Gratis MamiAds 120.000
      - paragraph: Rp79.000
      """
    And user verify Total Pembayaran
      """
      - paragraph: Total Pembayaran
      - paragraph: Rp79.000
      """
    And user choose saldo "30 ribu" on GoldPlus section
    And owner click bayar sekarang on detail tagihan page goldplus
    Then owner validate payment for goldplus package have "Saldo MamiAds 30 ribu + GoldPlus 1 (1 Bulan)" and have "Biaya Transaksi" before choose payment method
    And user navigate to mamiads history page
    And user will see that the text "Saldo MamiAds 30 ribu + GoldPlus 1 (1 Bulan)" is displayed

  @gpCrossPaid @TEST_LIMO-3353
  Scenario: [Goldplus ][Crosseling GP and MamiAds]Success buy cross-selling GP and mamiads
    And owner navigates to owner dashboard
    Then validate that owner have "Menunggu Pembayaran"
    And owner wants to paid GP crosseling by click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then payment owner success using ovo as payment method
    And user navigate to mamiads history page
    And user click "Selesai"
    And validate status transaction mamiads is "Lunas" with price "Rp109.500" saldo "Saldo MamiAds 30 ribu + GoldPlus 1 (1 Bulan)"