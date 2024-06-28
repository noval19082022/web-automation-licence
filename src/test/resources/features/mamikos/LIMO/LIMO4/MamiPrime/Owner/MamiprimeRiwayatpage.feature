@regression @LIMO4
Feature: Riwayat Mamiprime Page

  @TEST_LIMO-6063 @continue
  Scenario: Entry point riwayat mamiprime
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password   |
      | 0890910001 | 0890910001  | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    Then user see lihat riwayat button
    When user click lihat riwayat mamiprime button
    Then user redirected to mamiprime history page

  @TEST_LIMO-6064 @continue
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner doesn't have any transaction at tab dalam proses
    Then Owner will see empty state at tab dalam proses in halaman riwayat mamiprime

  @TEST_LIMO-6065
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner doesn't have any transaction at tab selesai
    When Owner click tab Selesai at riwayat pembelian mamiprime
    Then Owner will see empty state at tab selesai in halaman riwayat mamiprime

  @TEST_LIMO-6066 @continue
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner only have transaction unpaid at tab dalam proses
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545512 | 0          | 12345678 |
    And owner navigate to pendaftaran mamiprime page
    And Owner purchase mamiprime periode "7 Hari"
    And Owner navigate to riwayat pembelian mamiprime
    Then Owner will see transaction unpaid mamiprime

  @TEST_LIMO-6066
  Scenario: [WEB][Mamiprime][Riwayat Page]Redirection invoice unpaid mamiprime
    When Owner click the latest unpaid invoice mamiprime
    Then owner see jenis pembayaran "MamiPrime - Kata Kunci (7 Hari)"

  Scenario: Reset Mamiprime
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin wants to reset mamiprime for owner with property ID "1000030951"
