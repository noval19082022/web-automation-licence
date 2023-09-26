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
    Then user redirected to mamiads page

  @TEST_LIMO-289
  Scenario: Check redirection mamiads when all listing full occupied
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 083843666858 | 083843666858 | qwerty123    |
    Then user verify title "Rp25.000" and message "Pakai MamiAds, bikin iklan makin terlihat" in saldo MamiAds
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page

  @TEST_LIMO-295 @TEST_LIMO-296
  Scenario Outline: Never Purchase MamiAds and all listing is allocated and Ever Purchase MamiAds and all listing is allocated
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | <phone number> | <phone number> | <password>   |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    And user filter iklan by iklan nonaktif
    Then user see title "Semua Iklan Anda Sudah Naik" with message "Iklan properti Anda akan naik ke posisi yang lebih tinggi pada hasil pencarian."
    Examples:
      | phone number  | password  |
      | 089145645624  | qwerty123 |
      | 082233545514  | 12345678  |

  @TEST_LIMO-292 @TEST_LIMO-298
  Scenario Outline: Never Purchase MamiAds And Ever Purchase MamiAds, Saldo < 5000 and have active ads the first click will redirect to MamiAds Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | <phone number> | <phone number> | qwerty123    |
    And user click on Saldo MamiAds at owner dashboard
    Then user redirected to pembelian saldo mamiads page
    Examples:
      | phone number  |
      | 083832357442  |
      | 083176408323  |

  @TEST_LIMO-297
  Scenario: Never Purchase MamiAds, Saldo < 5000 and have not active ads the first click will redirect to MamiAds Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password     |
      | 089504016010 | 089504016010 | qwerty123    |
    Then user verify title "Rp3.500" and message "Beli saldo lagi yuk biar posisi iklan tetap naik" in saldo MamiAds
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to pembelian saldo mamiads page
    When user go back to previous page
    And user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page