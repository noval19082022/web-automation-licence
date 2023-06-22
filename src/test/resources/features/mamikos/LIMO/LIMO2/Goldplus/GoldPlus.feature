@regression @goldPlus @goldplusRegister @LIMO2 @listing-monetization
Feature: Gold Plus

  @TEST_LIMO-151 @chooseGP @continue
  Scenario: Owner choose gold plus 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 082233545506 | 0          | qwerty123 |
    And user click "Daftar" button
    And user choose Goldplus package 1
    Then user will see that the text "GoldPlus 1 (3 bulan) Rp168.150" is displayed

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

  @TEST_LIMO-150 @checkBenefit
  Scenario: Make sure detail Check Other Benefits on GP1/2
    Given user click "Ubah"
    When user click "Lihat Detail Manfaat"
    Then user will see that the text "Manfaat GoldPlus 2" is displayed

