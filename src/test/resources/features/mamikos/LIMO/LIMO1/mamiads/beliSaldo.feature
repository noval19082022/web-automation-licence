@regression @LIMO1 @LIMO1-staging @beliSaldo
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
    Then favorit saldo is "Rp150.000"

  @TEST_LIMO-3335 @continue
  Scenario: List Promo Saldo
    Then detail list saldo as expected
    """
- paragraph: Saldo Iklan
- paragraph: Harga
- radio
- paragraph
- paragraph: 10 ribu
- paragraph: Rp1.000
- paragraph: 88%
- paragraph: Rp8.000
- radio
- paragraph
- paragraph: 30 ribu
- paragraph: + Bonus 3 ribu (khusus GoldPlus)
- paragraph: Rp27.000
- paragraph: 19%
- paragraph: Rp33.000
- radio
- paragraph
- paragraph: 75 ribu
- paragraph: + Bonus 7.5 ribu (khusus GoldPlus)
- paragraph: Rp75.000
- paragraph: 15%
- paragraph: Rp87.500
- radio
- paragraph
- paragraph: 80 ribu
- paragraph: + Bonus 8 ribu (khusus GoldPlus)
- paragraph: Rp88.000
- radio
- paragraph
- paragraph: 150 ribu Favorit
- paragraph: Rp150.000
- radio
- paragraph
- paragraph: 300 ribu
- paragraph: + Bonus 24 ribu (khusus GoldPlus)
- paragraph: Rp276.000
- paragraph: 15%
- paragraph: Rp324.000
- radio
- paragraph
- paragraph: 850 ribu
- paragraph: + Bonus 85 ribu (khusus GoldPlus)
- paragraph: Rp935.000
- radio
- paragraph
- paragraph: 1 juta
- paragraph: + Bonus 100 ribu (khusus GoldPlus)
- paragraph: Rp850.000
- paragraph: 23%
- paragraph: Rp1.100.000
- radio
- paragraph
- paragraph: 10 juta
- paragraph: + Bonus 2 juta (khusus GoldPlus)
- paragraph: Rp7.000.000
- paragraph: 42%
- paragraph: Rp12.000.000
- radio
- paragraph
- paragraph: 20 juta
- paragraph: + Bonus 4.4 juta (khusus GoldPlus)
- paragraph: Rp10.000.000
- paragraph: 60%
- paragraph: Rp24.400.000
- button "Pilih Saldo" [disabled]
      """

  @TEST_LIMO-3336 @continue
  Scenario: Change Saldo
    Given owner choose saldo "Rp27.000"
    When owner ubah saldo to "Rp80.000"
    Then owner will see that the text "Saldo MamiAds 150 ribu" is displayed

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
      | phone stag | phone prod  | password  |
      | 0891202513 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp10.000" without buying Goldplus "notBuyGP"
    And payment owner success using ovo as payment method
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-8301
  Scenario: Purchase MamiAds with GP
    When owner navigates to owner dashboard
    And owner want to buy mamiads saldo with nominal "Rp10.000" with buying Goldplus "buyGP"
    And payment owner success using ovo as payment method
    Then owner verify invoice success paid mamiads

  @TEST_LIMO-8304
  Scenario: View MA-only Purchase
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod  | password  |
      | 0891202513 | 08123450977 | qwerty123 |
    And user navigates to mamiads pembelian saldo
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
      | phone stag | phone prod  | password  |
      | 0891202513 | 08123450977 | qwerty123 |
    And user navigates to mamiads pembelian saldo
    And owner want to buy mamiads saldo with nominal "Rp80.000"
    And user navigate to mamiads history page
    Then admin should be able to see the text "Saldo 80 ribu"
    And user continue payment buy saldo mamiads
    And owner set active page to 1
    And payment user success using ovo as payment method
    Then owner verify invoice success paid mamiads