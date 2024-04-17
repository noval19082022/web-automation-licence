@regression @LIMO4
Feature: Riwayat Mamiprime Page

  @TEST_LIMO-6063
  Scenario: Entry point riwayat mamiprime
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password   |
      | 0890910001 | 0890910001  | qwerty123  |
    And user click on mamiprime widget at owner dashboard
    Then user see lihat riwayat button
    When user click lihat riwayat mamiprime button
    Then user redirected to mamiprime history page