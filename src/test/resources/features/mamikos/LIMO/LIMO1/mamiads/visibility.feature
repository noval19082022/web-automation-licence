@regression @LIMO1 @LIMO1-staging @visibilityLimo @DONEMIGRATINGTONEWBOARD
Feature: Visibility

  @TEST_LIMO-1369 @continue
  Scenario: Check redirection mamiads Owner have condition Saldo mamiAds = 0, Never purchase mamiAds, Never Allocated then click entry point MA first time
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | phone prod    | password  |
      | 0826666666633 | 0826666666633 | qwerty123 |
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads landing page

  Scenario: Check redirection mamiads Owner have condition Saldo mamiAds = 0, Never purchase mamiAds, Never Allocated then click entry point MA
    When user go back to previous page
    Then user redirected to owner dashboard
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page

  @TEST_LIMO-1371
  Scenario: Check redirection mamiads when all listing full occupied
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 0891202415   | 083843666858 | qwerty123 |
    Then user will see that the text "500.000" is displayed
    Then user will see that the text "Posisi iklan tidak naik" is displayed
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page

  @TEST_LIMO-1365
  Scenario Outline: Never Purchase MamiAds and all listing is allocated and Ever Purchase MamiAds and all listing is allocated
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password   |
      | <phone number> | <phone number> | <password> |
    And user click on Saldo MamiAds at owner dashboard
    And user close mamiads onboarding popup
    And user filter iklan by iklan nonaktif
    Then user see title "Semua Iklan Anda Sudah Naik" with message "Iklan properti Anda akan naik ke posisi yang lebih tinggi pada hasil pencarian."
    Examples:
      | phone number | password  |
      | 089145645624 | qwerty123 |
      | 082233545514 | 12345678  |

  @TEST_LIMO-1370 @TEST_LIMO-1368
  Scenario Outline: Never Purchase MamiAds And Ever Purchase MamiAds, Saldo < 5000 and have active ads the first click will redirect to MamiAds Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password  |
      | <phone number> | <phone number> | qwerty123 |
    And user click on Saldo MamiAds at owner dashboard
    Then user redirected to pembelian saldo mamiads page
    Examples:
      | phone number |
      | 083832357442 |
      | 083176408323 |

  @TEST_LIMO-1363
  Scenario: Never Purchase MamiAds, Saldo < 5000 and have not active ads the first click will redirect to MamiAds Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089504016010 | 089504016010 | qwerty123 |
    Then user will see that the text "Beli saldo, banyak pilihan & diskon!" is displayed
    When user click on Saldo MamiAds at owner dashboard
    Then user redirected to pembelian saldo mamiads page
    When user go back to previous page
    And user click on Saldo MamiAds at owner dashboard
    Then user redirected to mamiads page