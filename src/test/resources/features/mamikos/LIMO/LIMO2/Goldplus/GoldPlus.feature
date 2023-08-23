@regression @goldPlus @goldplusRegister @LIMO2 @listing-monetization
Feature: Gold Plus

  @TEST_LIMO-1661 @chooseGP @continue
  Scenario: [Goldplus][Owner Dashboard][Widget GP] Check owner can select package GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    And user click "Daftar" button
    And user choose Goldplus package 1
    Then user will see that the text "GoldPlus 1 (Paket Chat) periode 4 Bulan" is displayed

  @TEST_LIMO-146 @changeGP @continue
  Scenario: Owner Able to Change Goldplus Package
    Given user click "Ubah"
    When user choose Goldplus package 2
    Then user will see that the text "Goldplus 2 (4 bulan) Rp320.000" is displayed

  @TEST_LIMO-148 @TEST_LIMO-149 @uncheckT&C @continue
  Scenario: Owner Cek warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then user will see that the text "Mohon untuk menyetujui Syarat dan Ketentuan yang berlaku" is displayed
    Then The system should display "Bayar Sekarang" button as disabled

  @checkAndUncheckT&C @continue
  Scenario: Owner Cek syarat dan ketentuan before uncheck and check warning toast and button bayar sekarang disable if uncheck the checkbox
    Given user click checkbox Syarat dan Ketentuan Umum GoldPlus
    Then The system should display "Bayar Sekarang" button as enabled

  @TEST_LIMO-150 @checkBenefit @continue
  Scenario: Make sure detail Check Other Benefits on GP1/2
    Given user click "Ubah"
    When user click "Lihat Detail Manfaat"
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

  @TEST_LIMO-2624
  Scenario: [WEB][Owner Dashboard][Widget GP] Check condition widget GP when waiting for payment
    When owner close pop up detail manfaat
    And user wants to subscribe Goldplus 1
    When owner click back previous button
    And user navigates to owner dashboard
    Then validate that owner have "Menunggu Pembayaran"

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


