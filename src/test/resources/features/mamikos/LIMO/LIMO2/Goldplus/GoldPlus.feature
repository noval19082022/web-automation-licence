@regression @goldPlus @goldplusRegister @LIMO2 @listing-monetization @DONEMIGRATINGTONEWBOARD
Feature: Gold Plus

  @TEST_LIMO-3396 @chooseGP @continue
  Scenario: [Goldplus][Owner Dashboard][Widget GP] Check owner can select package GP
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "082233545506"

    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    And user click daftar GP button
    And user click "Pilih Paket GoldPlus" button
    And owner choose Goldplus package 1
    And owner click bayar sekarang on detail tagihan page goldplus
    Then user will see that the goldplus package choosed is displayed

  @TEST_LIMO-3397 @changeGP @continue
  Scenario: Owner Able to Change Goldplus Package
    When user click on ubah package gold plus button
    And owner choose Goldplus package 2
    And owner click bayar sekarang on detail tagihan page goldplus
    Then user will see that the goldplus package on rincian pembayaran detail tagihan

  @TEST_LIMO-3398 @TEST_LIMO-149 @uncheckT&C @continue
  Scenario: Owner Cek warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then owner can see toast with content text is "Mohon untuk menyetujui Syarat dan Ketentuan yang berlaku"
    And The system should display "Bayar Sekarang" button as disabled

  @TEST_LIMO-3399 @checkAndUncheckT&C @continue
  Scenario: Owner Cek syarat dan ketentuan before uncheck and check warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then The system should display "Bayar Sekarang" button as enabled

  @TEST_LIMO-3400 @checkBenefit @continue
  Scenario: Make sure detail Check Other Benefits on GP1/2
    When user click on ubah package gold plus button
#    When user click "Lihat Detail Manfaat"
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST_LIMO-3401
  Scenario: [WEB][Owner Dashboard][Widget GP] Check condition widget GP when waiting for payment
#    When owner close pop up detail manfaat
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

#  @TEST_LIMO-3402 @GP @automated @listing-monetization @web @web-covered
#  Scenario: [Owner][GP Widget]Check GP Widget "Sedang Diproses"
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod | password  |
#      | 086465400654 | 0          | qwerty123 |
#    Then validate that owner have "Sedang Diproses"

  @TEST_LIMO-3403
  Scenario: [WEB][Pilih Paket GP] Owner wants to check "Lihat Detail Manfaat" of GoldPlus 2 and GoldPlus 1
    #detail manfaat GP 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    And owner navigate to list goldplus package
    Then owner see benefit in "golplus 1" is "Chat tanpa batas" is displayed
    Then owner see benefit "Iklan lebih prioritas dari non-GoldPlus" is displayed
    Then owner see benefit "Lihat profil penyewa dasar" is displayed
    Then owner see benefit "Daftar Tunggu 10 penyewa" is displayed
    Then owner see benefit "Terima Survei Kos fitur dasar" is displayed
    Then owner see benefit in "golplus 1" is "Cek Properti Sekitar" is displayed
    Then owner see benefit in "golplus 1" is "Buat Promo Iklan" is displayed
    Then owner see benefit "Cashback MamiAds mulai dari 7.500" is displayed

    #detail manfaat GP 2
   # When owner wants to see Lihat Detail Manfaat Goldplus Dua
    Then owner see benefit in "golplus 2" is "Chat tanpa batas" is displayed
    Then owner see benefit in "golplus 2" is "Iklan lebih prioritas dari GoldPlus 1" is displayed
    Then owner see benefit "Lihat profil penyewa lengkap" is displayed
    Then owner see benefit in "golplus 2" is "Daftar Tunggu tanpa batas" is displayed
    Then owner see benefit in "golplus 2" is "Terima Survei Kos fitur penuh" is displayed
    Then owner see benefit in "golplus 2" is "Cek Properti Sekitar" is displayed
    Then owner see benefit in "golplus 2" is "Buat Promo Iklan" is displayed
    Then owner see benefit in "golplus 2" is "Broadcast Chat" is displayed
    Then owner see benefit "Cashback MamiAds mulai dari 35.000" is displayed

  @TEST_LIMO-3404
  Scenario: [WEB][Pilih Paket GP] As a property owner, I would like to know the difference between GP 1 and GP 2 benefits
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag    | phone prod | password  |
      | 0812345670001 | 0          | qwerty123 |
    When owner navigate to list goldplus package
    #list manfaat Goldplus 2
    Then owner see benefit "Lihat profil penyewa dasar" is displayed
    And owner see benefit in "golplus 2" is "Lihat profil penyewa lengkap" is displayed
    And owner see benefit "Iklan lebih prioritas dari non-GoldPlus" is displayed
    And owner see benefit in "golplus 2" is "Iklan lebih prioritas dari GoldPlus 1" is displayed
    #list manfaat Goldplus 1
    And owner see benefit "Terima Survei Kos fitur penuh" is displayed
    And owner see benefit "Terima Survei Kos fitur dasar" is displayed
    And owner see benefit "Daftar Tunggu tanpa batas" is displayed
    And owner see benefit "Daftar Tunggu 10 penyewa" is displayed