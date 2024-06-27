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
