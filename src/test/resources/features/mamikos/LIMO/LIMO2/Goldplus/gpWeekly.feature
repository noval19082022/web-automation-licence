@regression @LIMO2 @listing-monetization @LIMO2-staging
Feature: GP Weekly

  @TEST_LIMO-3907 @continue
  Scenario: List period GP Weekly
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    When owner navigate to list package goldplus 2
    Then user verify list of Goldplus Weekly is appear
      | periodGP | price    |
      | 1 Minggu | Rp25.000 |
      | 2 Minggu | Rp17.500 |

  @TEST_LIMO-3907
  Scenario: Select GP Weekly
    Given owner choose periode goldplus "1 Minggu"
    Then user will see that the text "GoldPlus 2 periode 1 Minggu" is displayed
