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

  @TEST_LIMO-3907 @continue
  Scenario: Select GP Weekly
    Given owner choose periode goldplus "1 Minggu"
    Then user will see that the text "GoldPlus 2 periode 1 Minggu" is displayed

  @TEST_LIMO-3914 @continue
  Scenario: GoldPlus Weekly Paid
    Given owner click bayar sekarang on detail tagihan page goldplus
    Then user will see that the text "GoldPlus 2 periode 1 Minggu" is displayed
    And payment owner success using ovo as payment method

   #reset GP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "081905128517"


