@regression @LIMO4 @mamiprimeRiwayatPage1
Feature: Riwayat Mamiprime Page

  @TEST_LIMO-3540 @continue @WEB @AUTOMATED
  Scenario: Entry point riwayat mamiprime
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202601 | 0          | qwerty123 |
    And owner close gp onboarding if exist
    And user click on mamiprime widget at owner dashboard
    Then user see lihat riwayat button
    When user click lihat riwayat mamiprime button
    Then user redirected to mamiprime history page

  @TEST_LIMO-3538 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner doesn't have any transaction at tab dalam proses
    Then Owner will see empty state at tab dalam proses in halaman riwayat mamiprime

  @TEST_LIMO-3542 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner doesn't have any transaction at tab selesai
    When Owner click tab Selesai at riwayat pembelian mamiprime
    Then Owner will see empty state at tab selesai in halaman riwayat mamiprime

  @TEST_LIMO-605 @continue @WEB @AUTOMATED
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner only have transaction unpaid at tab dalam proses
    When owner navigate to pendaftaran mamiprime page
    Then owner select option mamiprime "Halaman Hasil Pencarian" from mamiprime landing
    And Owner purchase mamiprime periode "7 Hari"
    And Owner navigate to riwayat pembelian mamiprime
    Then Owner will see transaction unpaid mamiprime

  @TEST_LIMO-3536 @WEB @AUTOMATED
  Scenario: [WEB][Mamiprime][Riwayat Page]Redirection invoice unpaid mamiprime
    When Owner click the latest unpaid invoice mamiprime
    Then owner see jenis pembayaran "MamiPrime - Halaman Hasil Pencarian (7 Hari)"

  @testDataPrepared @WEB @AUTOMATED
  Scenario: Reset Mamiprime
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin wants to reset mamiprime for owner with property ID "1000030951"
    And admin mamipay wants to reset mamiprime srp for owner with property ID "1000047451"

  @TEST_LIMO-3537 @WEB @AUTOMATED
  Scenario: [WEB][Mamiprime][Riwayat Page]Owner have transaction paid and active prime at tab selesai
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545512 | 0          | 12345678 |
    And owner navigate to pendaftaran mamiprime page
    Then owner select option mamiprime "Halaman Hasil Pencarian" from mamiprime landing
    And Owner purchase mamiprime periode "7 Hari"
    Then payment owner success using ovo as payment method
    When Owner navigate to riwayat pembelian mamiprime
    Then Owner will see transaction paid mamiprime

  @testDataPrepared @WEB @AUTOMATED
  Scenario: Reset Mamiprime
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
#    And admin wants to reset mamiprime for owner with property ID "1000030951"
    And admin mamipay wants to reset mamiprime srp for owner with property ID "1000030951"