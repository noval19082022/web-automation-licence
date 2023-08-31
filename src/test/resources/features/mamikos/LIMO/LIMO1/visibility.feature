@regression @LIMO1 @LIMO1-staging
Feature: Visibility

  @TEST_LIMO-291
  Scenario: Saldo mamiAds = 0 - Never purchase mamiAds - Never Allocated
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0826666666633 | 0826666666633 | qwerty123    |
    Then user verify message "Iklan Anda tenggelam? Pakai MamiAds!" in saldo MamiAds
    When user verify title "Lihat disini" in saldo MamiAds
    And user click on Saldo MamiAds button
    Then user redirected to "/mamiads?redirectionSource=Owner%20Dashboard"
    When user go back to previous page
    And user redirected to "https://owner-jambu.kerupux.com/"
    Then owner should successfully log out
    When user login as owner:
      | phone stag    | phone prod    | password     |
      | 0826666666633 | 0826666666633 | qwerty123    |
    Then user verify message "Iklan Anda tenggelam? Pakai MamiAds!" in saldo MamiAds
    When user verify title "Lihat disini" in saldo MamiAds
    And user click on Saldo MamiAds button
    Then user redirected to "/mamiads?redirectionSource=Owner%20Dashboard"
    When user go back to previous page
    And user redirected to "https://owner-jambu.kerupux.com/"
    And user click on Saldo MamiAds button
    Then user redirected to "/mamiads"

  @TEST_LIMO-289
  Scenario: All listing full occupied
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 083843666858 | 083843666858 | qwerty123    |
    Then user verify message "Pakai MamiAds, bikin iklan makin terlihat" in saldo MamiAds
    When user verify title "Rp25.000" in saldo MamiAds
    And user click on Saldo MamiAds button
    Then user redirected to "/mamiads"