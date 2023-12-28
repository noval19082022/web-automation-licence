@regression @LIMO2 @listing-monetization @LIMO2-staging
Feature: GP Weekly

  @TEST_LIMO-3907
  Scenario: List period GP Weekly
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    When owner navigate to list package goldplus 2
    Then user verify list of Weekly Goldplus is appear
      | periodGP | price    |
      | 1 Minggu | Rp25.000 |
      | 2 Minggu | Rp17.500 |
