@LIMO2
Feature: Payment mamiads staging


  @TEST_SS-3097
  Scenario: [Owner][Payment premium] Owner paid premium paket using Alfamart
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp30.000"
    And owner select payment using alfamart xendit as payment method from invoice detail
    Then owner verify invoice success paid mamiads

  @TEST_SS-3099 @paymentPermata
  Scenario: [Owner][Payment premium] Owner paid premium paket using Permata
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment method from invoice detail using "PERMATA"
    Then owner verify invoice success paid mamiads

  @TEST_SS-3100
  Scenario: [Owner][Payment premium] Owner paid premium paket using LinkAja
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment from invoice detail using LinkAja
    Then owner verify invoice success paid mamiads

  @TEST_SS-3101
  Scenario: [Owner][Payment premium] Owner paid premium paket using DANA
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment from invoice detail with DANA
    Then owner verify invoice success paid mamiads

  @TEST_SS-3102
  Scenario: [Owner][Payment premium] Owner paid premium paket using CC
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment from invoice detail using Credit Card
    Then owner verify invoice success paid mamiads

  @TEST_SS-3103
  Scenario: [Owner][Payment premium] Owner paid premium paket using BNI
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment method from invoice detail using BNI
    Then owner verify invoice success paid mamiads

  @TEST_SS-3104
  Scenario: [Owner][Payment premium] Owner paid premium paket using BRI
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment method from invoice detail using BRI
    Then owner verify invoice success paid mamiads

  @TEST_SS-3105
  Scenario: [Owner][Payment premium] Owner paid premium paket using Mandiri
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner pay invoice from invoice detail using mandiri without close the page
    Then owner verify invoice success paid mamiads