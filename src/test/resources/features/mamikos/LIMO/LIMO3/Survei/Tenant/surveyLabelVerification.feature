@regression @LIMO1
Feature: Survei - Verification of survey label below price on GP kost detail


  @payWithDana
  Scenario: Owner Purchase GP using dana
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 0891202418   | 0          | qwerty123 |
    And owner waiting the page reload
    And user click daftar GP button
    And user wants to subscribe Goldplus 2
    And owner select payment from invoice detail with DANA
    And owner set active page to 0
    And owner navigates to "/goldplus/payment"
    And owner click filter "Selesai" in Pembayaran Tagihan Goldplus page
    Then owner will see that the text "Lunas" is displayed

  @TEST_LIMO-9645
  Scenario: GP Listing - Waiting list Label with Maximum+ Value
    Given user navigate to mamikos
    And user search for Kost with name "Kost Draft Mamipayy QLPXL3A5 TIPE A1" and selects matching result
    And user open detail page GP listing
    And user check section label below price
    Then Verifikasi label survey tampil "Banyak peminat! 4+ orang di daftar tunggu"

  @TEST_LIMO-9632
  Scenario: Verify survey popularity label is displayed below price on GP kost detail
    Given user navigate to mamikos
    And user search for Kost with name "Kost Rotary Bintaro 2 Pasar Kemis Tangerang" and selects matching result
    And user open detail page GP listing
    And user dismiss FTUE booking benefit
    And user check section label below price
    Then Verifikasi label survey tampil "Sedang populer! 3 orang mengajukan survei"

  @TEST_LIMO-9633
  Scenario: GP Listing - Survey Label with Maximum+ Value
    Given user navigate to mamikos
    And user search for Kost with name "Kost Royal Safari Utara B Rajeg Tangerang" and selects matching result
    And user open detail page GP listing
    And user check section label below price
    Then Verifikasi label survey tampil "Sedang populer! 3+ orang mengajukan survei"

  @TEST_LIMO-9634
  Scenario: GP Listing - Waiting List Label Displayed
    Given user navigate to mamikos
    And user search for Kost with name "Kost Mie Tiaw Rajeg Tangerang" and selects matching result
    And user open detail page GP listing
    And user check section label below price
    Then Verifikasi label survey tampil "Banyak peminat! 4 orang di daftar tunggu"

  @TEST_LIMO-9633
  Scenario: Verify survey label is NOT displayed for non-GP kost detail
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "0891202418"
    Given user navigate to mamikos
    When user Login with tenant
    And user search for Kost with name "Kost Draft Mamipayy QLPXL3A5 Tipe A6 Pasarkemis Tangerang" and selects matching result
    Then user check the label not displayed