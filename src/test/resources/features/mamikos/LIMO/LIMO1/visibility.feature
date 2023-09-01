@regression @LIMO1 @LIMO1-staging
Feature: Visibility

  @TEST_LIMO-291 @continue
  Scenario: Check redirection mamiads Owner have condition Saldo mamiAds = 0, Never purchase mamiAds, Never Allocated then click entry point MA first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0826666666633 | 0826666666633 | qwerty123    |
    Then user verify title "Lihat disini" and message "Iklan Anda tenggelam? Pakai MamiAds!" in saldo MamiAds
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads landing page

  Scenario: Check redirection mamiads Owner have condition Saldo mamiAds = 0, Never purchase mamiAds, Never Allocated then click entry point MA
    When user go back to previous page
    Then user redirected to owner dashboard
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page from sidebar

  @TEST_LIMO-289
  Scenario: Check redirection mamiads when all listing full occupied
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 083843666858 | 083843666858 | qwerty123    |
    Then user verify title "Rp25.000" and message "Pakai MamiAds, bikin iklan makin terlihat" in saldo MamiAds
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page from owner dashboard