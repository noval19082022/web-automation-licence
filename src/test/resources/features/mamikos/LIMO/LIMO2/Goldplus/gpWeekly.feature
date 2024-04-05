@regression @LIMO2 @listing-monetization @LIMO2-staging @gpWeekly
Feature: GP Weekly

  @TEST_LIMO-3914 @continue
  Scenario: Goldplus Weekly Package
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    And owner navigate to list goldplus package
    Then owner will see that the text "Mulai Dari" is displayed
    And owner should not be able to see the text "per bulan"

  @TEST_LIMO-3907 @continue
  Scenario: List period GP Weekly
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

  @TEST_LIMO-3914 @continue
  Scenario: GoldPlus Weekly Paid - Checking Widget
    Given owner navigates to owner dashboard
    When owner click close icon pop up
    Then validate that owner have "GoldPlus 2"

 @continue
  Scenario: [Owner][GP Recurring] Owner want to cancel GP Recurring via pop up reminder
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    When user sets recurring "H3" for number "081905128517"

  @TEST_LIMO-4015 @continue
  Scenario: GoldPlus Weekly Recurring - Cancel Recurring
    Given owner navigates to owner dashboard
    And owner click nanti saja for recurring GoldPlus
    When owner wants to access goldplus dashboard
    Then owner will be redirected to invoice recurring

  @TEST_LIMO-4015
  Scenario: [Owner][GP Recurring] Owner want to extend GP via pop up reminder
    When user sets recurring "H1" for number "081905128517"
    And owner navigates to owner dashboard
    When owner wants to proccess recurring GP
    Then payment owner success using ovo as payment method
    And owner navigates to owner dashboard
    And owner should not be able to see the text "Perpanjang paket Goldplus yuk!"

   #reset GP
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    And admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "081905128517"

  @TEST_LIMO-3919
  Scenario: GoldPlus Weekly - Checking Widget After Terminated
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081905128517 | qwerty123 |
    Then widget daftar goldplus is displayed
