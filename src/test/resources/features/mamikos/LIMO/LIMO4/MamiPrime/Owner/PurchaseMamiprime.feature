@regression @LIMO4 @purchaseMamiprime
Feature: Purchase Mamiprime

  @TEST_LIMO-644 @WEB @AUTOMATED
  Scenario Outline: [WEB][Mamikos Prime][Beli Paket] Owner doesn't have property active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | <phone number> | <phone number> | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime
    Examples:
      | phone number  |
      | 082220240418  |
      | 082120240419  |
      | 082020240419  |
      | 082220240419  |

  @TEST_LIMO-628 @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Beli Paket] Owner only have apartment active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password   |
      | 082320240418 | 082320240418 | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime

  @TEST_LIMO-624 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] Ubah Periode
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password   |
      | 082233545512 | 0            | 12345678  |
    And owner navigate to pendaftaran mamiprime page
    And owner already choose period "7 Hari" with price "Rp237.500"
    And owner wants to change "MamiPrime - Kata Kunci (7 Hari)" at detail tagihan page
    Then owner will back to pendafatarn mamiprime page

  @TEST_LIMO-3563 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] set different period after click ubah
    When owner already choose period "14 Hari" with price "Rp475.000"
    Then owner can see package prime selected is "MamiPrime - Kata Kunci (14 Hari)"

  @TEST_LIMO-625 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Pendaftaran Mamiprime] Detail Tagihan
    Then owner can see property name in detail tagihan mamiprime

  @TEST_LIMO-3564 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] Bayar Sekarang
    When owner click bayar sekarang at detail tagihan mamiprime
    Then owner will see that the text "MamiPrime - Kata Kunci (14 Hari)" is displayed

  @TEST_LIMO-641 @WEB @AUTOMATED
  Scenario: [WEB][Mamikos Prime][Universal Invoice] Owner wants to paid prime invoice
    When payment owner success using ovo as payment method

  @dataPrepareScenario @WEB @AUTOMATED
  Scenario: Reset Mamiprime
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin wants to reset mamiprime for owner with property ID "1000030951"
