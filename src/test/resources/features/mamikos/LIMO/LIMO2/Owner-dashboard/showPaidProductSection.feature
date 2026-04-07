@LIMO2
Feature: Show Paid Product Section (Gold Plus)

  @TEST_LIMO-10671 @gpsubspaidproduct @continue
  Scenario: [Owner][OD][GP] Non GP owner sees GoldPlus entry point and can subscribe
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
    Then user will see that the text "Manfaat GoldPlus 1" is displayed
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST-LIMO-10673 @TEST_LIMO-10677 @gpsubspaidproduct @continue
  Scenario: [Owner][OD][GP] Owner with unpaid GP payment sees payment reminder
    Given user wants to subscribe Goldplus 1
    When owner navigates to owner dashboard
    Then owner will see that the text "Menunggu Pembayaran" is displayed
    And owner wants to paid GP crosseling by click "Lihat Tagihan" on pop up "Anda masih memiliki tagihan aktif"
    Then payment owner success using ovo as payment method

  @TEST-LIMO-10674 @TEST-LIMO-10676 @gpsubspaidproduct
  Scenario: [Owner][OD][GP] Active GP owner sees subscription status
    When owner navigates to owner dashboard
    * owner click close icon pop up
#    Then validate that owner have "GoldPlus 1"
    And user click info untuk anda "Selamat, Anda bebas kirim chat tanpa kuota sebagai pelanggan GoldPlus."
    Then owner will see GoldPlus logo image "logo-goldplus-gradient-1.webp"

  @TEST_LIMO-10672
  Scenario: [Owner][OD][GP] Non GP owner with GPSP eligibility sees special price offer
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 081597877123 | 0          | qwerty123 |
    Then owner will see that the text "Khusus Pengguna Baru" is displayed
    And owner will see that the text "Tawaran berakhir dalam" is displayed
    And owner see GPSP promo countdown
    And owner check countdown value running
    Then owner wants to accses dashboard GP
    And Owner see gp onboarding pop up is exist
    And user click "Pilih Paket GoldPlus" button
    Then user will see that the text "Manfaat GoldPlus 1" is displayed
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

