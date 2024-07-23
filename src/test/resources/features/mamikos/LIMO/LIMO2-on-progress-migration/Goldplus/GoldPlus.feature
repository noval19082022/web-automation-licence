@regression @goldPlus @goldplusRegister @LIMO2 @listing-monetization
Feature: Gold Plus

  @TEST_LIMO-1661 @chooseGP @continue
  Scenario: [Goldplus][Owner Dashboard][Widget GP] Check owner can select package GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    And user click daftar GP button
    And user choose Goldplus package 1
    Then user will see that the goldplus package choosed is displayed

  @TEST_LIMO-146 @changeGP @continue
  Scenario: Owner Able to Change Goldplus Package
    When user click on ubah package gold plus button
    And user choose Goldplus package 2
    Then user will see that the goldplus package on rincian pembayaran detail tagihan

  @TEST_LIMO-148 @TEST_LIMO-149 @uncheckT&C @continue
  Scenario: Owner Cek warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then owner can see toast with content text is "Mohon untuk menyetujui Syarat dan Ketentuan yang berlaku"
    And The system should display "Bayar Sekarang" button as disabled

  @checkAndUncheckT&C @continue
  Scenario: Owner Cek syarat dan ketentuan before uncheck and check warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then The system should display "Bayar Sekarang" button as enabled

  @TEST_LIMO-150 @checkBenefit @continue
  Scenario: Make sure detail Check Other Benefits on GP1/2
#    Given user click "Ubah"
    When user click on ubah package gold plus button
    When user click "Lihat Detail Manfaat"
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST_LIMO-2624
  Scenario: [WEB][Owner Dashboard][Widget GP] Check condition widget GP when waiting for payment
    When owner close pop up detail manfaat
    And user wants to subscribe Goldplus 1
    When owner click back previous button
    And user navigates to owner dashboard
    Then validate that owner have "Menunggu Pembayaran"
    And owner should successfully log out

    @continue #reset GP
    Scenario: delete or reset data GP
      Given admin go to mamikos mamipay admin
      And admin login to mamipay:
        | email stag                   | email prod                   | password  |
        | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
      Then user wants to reset Goldplus for owner with phone number "082233545506"

  @TEST_LIMO-1662 @GP @automated @listing-monetization @web @web-covered
  Scenario: [Owner][GP Widget]Check GP Widget "Sedang Diproses"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 086465400654 | 0          | qwerty123 |
    Then validate that owner have "Sedang Diproses"

  @TEST_LIMO-5078
  Scenario: [WEB][Pilih Paket GP] Owner wants to check "Lihat Detail Manfaat" of GoldPlus 2 and GoldPlus 1
    #detail manfaat GP 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    And owner navigate to list goldplus package
    When owner wants to see Lihat Detail Manfaat Goldplus Satu
    Then owner see benefit "Manfaat GoldPlus 1" is displayed
    Then owner see benefit "Kos lebih diprioritaskan dari kos tanpa GoldPlus." is displayed
    Then owner see benefit "Cek bisnis kos di dekat Anda dengan fitur Cek Properti Sekitar." is displayed
    Then owner see benefit "Pasang promo properti dengan fitur Promo Iklan." is displayed
    Then owner see benefit "Bonus 10% saat beli saldo MamiAds." is displayed
    Then owner see benefit "Harga khusus Paket MamiFoto mulai dari Rp 600.000 hingga Rp 1.000.000 (Harga asli Rp 1.300.000)." is displayed
    Then owner see benefit "Gratis Saldo MamiAds dengan pembelian GoldPlus bulanan." is displayed
    And owner click close icon pop up
    #detail manfaat GP 2
    When owner wants to see Lihat Detail Manfaat Goldplus Dua
    Then owner see benefit "Manfaat GoldPlus 2" is displayed
    Then owner see benefit "Kuota tanpa batas untuk membalas chat dari pencari kos." is displayed
    Then owner see benefit "Bisa melihat info dan riwayat aktivitas pencari kos yang chat maupun mengajukan sewa di kos Anda." is displayed
    Then owner see benefit "Promosikan kos Anda dengan fitur Broadcast Chat." is displayed
    Then owner see benefit "Kos lebih diprioritaskan dari GoldPlus 1 dan kos tanpa GoldPlus." is displayed
    Then owner see benefit "Cek bisnis kos di dekat Anda dengan fitur Cek Properti Sekitar." is displayed
    Then owner see benefit "Pasang promo properti dengan fitur Promo Iklan." is displayed
    Then owner see benefit "Bonus 15% saat beli saldo MamiAds." is displayed
    Then owner see benefit "Harga khusus Paket MamiFoto mulai dari Rp 600.000 hingga Rp 1.000.000 (Harga asli Rp 1.300.000)." is displayed
    Then owner see benefit "Gratis Saldo MamiAds dengan pembelian GoldPlus bulanan." is displayed

  @TEST_LIMO-5079
  Scenario: [WEB][Pilih Paket GP] As a property owner, I would like to know the difference between GP 1 and GP 2 benefits
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    When owner navigate to list goldplus package
    #list manfaat Goldplus 2
    Then owner see benefit "Lihat profil calon penyewa yang menghubungi Anda" is displayed
    And owner see benefit in "golplus 2" is "Balas chat tanpa batas dengan pencari kos" is displayed
    And owner see benefit "Promosikan kos Anda dengan fitur Broadcast Chat" is displayed
    And owner see benefit "Kos lebih diprioritaskan dari GoldPlus 1 dan kos tanpa GoldPlus" is displayed
    And owner see benefit in "golplus 2" is "Cek bisnis kos di dekat Anda dengan fitur Cek Properti Sekitar" is displayed
    #list manfaat Goldplus 1
    And owner see benefit "Cashback dan bonus Saldo Mamiads" is displayed
    And owner see benefit in "golplus 1" is "Balas chat tanpa batas dengan pencari kos" is displayed
    And owner see benefit in "golplus 1" is "Cek bisnis kos di dekat Anda dengan fitur Cek Properti Sekitar" is displayed