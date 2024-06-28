@regression @LIMO4 @purchaseMamiprime
Feature: Purchase Mamiprime

  @TEST_LIMO-5711
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

  @TEST_LIMO-5769
  Scenario: [WEB][Mamikos Prime][Beli Paket] Owner only have apartment active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password   |
      | 082320240418 | 082320240418 | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    Then user will see pop up doesnt have property on mamiprime

  @TEST_LIMO-5798 @continue
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] Ubah Periode
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password   |
      | 082233545512 | 0            | 12345678  |
    And owner click close icon pop up
    And user click on mamiprime widget at owner dashboard
    And owner wants to buy mamiprime from header
    And owner already choose period "7 Hari" with price "Rp237.500"
    When owner wants to change "MamiPrime - Kata Kunci (7 Hari)" at detail tagihan page
    Then owner will back to pendafatarn mamiprime page

   @continue
  Scenario: [WEB][Mamikos Prime][Detail Tagihan] set different period after click ubah
    When owner already choose period "14 Hari" with price "Rp475.000"
    Then owner can see package prime selected is "MamiPrime - Kata Kunci (14 Hari)"

  @TEST_LIMO-5797
  Scenario: [WEB][Mamikos Prime][Pendaftaran Mamiprime] Detail Tagihan
    Then owner can see property name in detail tagihan mamiprime

  Scenario: Reset Mamiprime
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin wants to reset mamiprime for owner with property ID "1000035857"
