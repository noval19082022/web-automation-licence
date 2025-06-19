@regression @LIMO1 @LIMO1-staging @beliSaldo @DONEMIGRATINGTONEWBOARD
Feature: Beli Saldo

  @TEST_LIMO-3333 @belisaldo @continue
  Scenario: Redirection Beli Saldo
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And user click Beli Saldo on mamiads dashboard
    Then user redirected to pembelian saldo mamiads page

  @TEST_LIMO-3334 @continue
  Scenario: Favorite Saldo
    Then favorit saldo is "Rp1.350.000"

  @TEST_LIMO-3335 @continue
  Scenario: List Promo Saldo
    Then detail list saldo as expected
      | priceTitle | priceInRp | disc | priceStrike |
      | 10 ribu    | Rp10.000  |      |             |
      | 30 ribu    | Rp27.000  | 10%  | Rp30.000    |
      | 50 ribu    | Rp50.000  |      |             |
      | 75 ribu    | Rp75.000  | 6%   | Rp80.000    |
      | 80 ribu    | Rp80.000  |      |             |
      | 300 ribu   | Rp276.000 |      | Rp300.000   |

  @TEST_LIMO-3336 @continue
  Scenario: Change Saldo
    Given owner choose saldo "Rp27.000"
    When owner ubah saldo to "Rp10.000"
    Then owner will see that the text "Saldo MamiAds 10 ribu" is displayed

  @TEST_LIMO-3337 @continue
  Scenario: Beli Saldo - Transaction Success
    Given owner click bayar sekarang in detail tagihan for saldo mamiads
    Then payment owner success using ovo as payment method

  @TEST_LIMO-3338
  Scenario: Beli Saldo - Click Selesai Button To make sure redirect to mamiads dashboard if tab Selesai button
    Given owner click button selesai on universal invoice
    Then verify redirect to mamiads dashboard

  @TEST_LIMO-3339 @continue
  Scenario: Beli Saldo (2nd Transaction)
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And user close mamiads onboarding popup
    And user wants to buy saldo MamiAds "Rp6.000"

  @TEST_LIMO-3340 @continue
  Scenario: Buy saldo mamiAds using voucher
    Given user using voucher "MAMASSPERCENT" to pay mamiads
    Then payment owner success using ovo as payment method

  @TEST_LIMO-3341
  Scenario: Checking history success transaction of mamiads using voucher
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-3342
  Scenario: Cancel Buy Saldo
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 085720962106 | 0          | qwerty123 |
    And user navigates to mamiads pembelian saldo
    And owner choose saldo "Rp27.000"
    And user navigate to mamiads history page
    And user will see title and message on Dalam Proses tab
    And user click "Selesai"
    Then user will see title and message on Selesai tab

  @TEST_LIMO-8300 @continue
  Scenario: Purchase MamiAds without GP
    #scenario reset gp
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "0891202513"
   #scenario buy mamiads
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 0891202513  | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp10.000" without buying Goldplus "notBuyGP"
    And payment owner success using ovo as payment method
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-8301
  Scenario: Purchase MamiAds with GP
    And owner close page number 1
    When owner navigates to owner dashboard
    And owner want to buy mamiads saldo with nominal "Rp10.000" with buying Goldplus "buyGP"
    And payment owner success using ovo as payment method
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-8304
  Scenario: View MA-only Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 0891202513  | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp80.000"
    And user navigate to mamiads history page
    Then admin should be able to see the text "Saldo 80 ribu"
    And user continue payment buy saldo mamiads
    And owner set active page to 1
    And payment user success using ovo as payment method
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-8305
  Scenario: View MA + GP Purchase
    #scenario reset gp
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "0891202513"
   #scenario buy mamiads
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 0891202513  | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp80.000"
    And user navigate to mamiads history page
    Then admin should be able to see the text "Saldo 80 ribu"
    And user continue payment buy saldo mamiads
    And owner set active page to 1
    And payment user success using ovo as payment method
    Then owner verify invoice success paid mamiads