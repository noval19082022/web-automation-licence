@regression @LIMO1 @LIMO1-staging
Feature: Beli Saldo

  @TEST_LIMO-274 @belisaldo @continue
  Scenario: Redirection Beli Saldo
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password  |
      | 083176408449 | 0          | qwerty123 |
    And user navigates to mamiads dashboard
    And user click Beli Saldo on mamiads dashboard
    Then user redirected to pembelian saldo mamiads page

  @TEST_LIMO-4086 @continue
  Scenario: Favorite Saldo
    Then favorit saldo is "Rp1.350.000"

  @TEST_LIMO-4087 @continue
  Scenario: List Promo Saldo
    Then detail list saldo as expected
      | price     | priceInRp   | disc | discPrice   |
      | 6.000     | Rp6.000     |      |             |
      | 30.000    | Rp27.000    | 10%  | Rp30.000    |
      | 50.000    | Rp50.000    |      |             |
      | 80.000    | Rp75.000    | 6%   | Rp80.000    |
      | 205.000   | Rp205.000   |      |             |
      | 300.000   | Rp276.000   | 8%   | Rp300.000   |
      | 850.000   | Rp850.000   |      |             |
      | 1.000.000 | Rp925.000   | 7%   | Rp1.000.000 |
      | 1.500.000 | Rp1.350.000 | 10%  | Rp1.500.000 |
      | 5.000.000 | Rp4.500.000 | 10%  | Rp5.000.000 |

  @TEST_LIMO-274 @continue
   Scenario: Change Saldo
    Given owner choose saldo "Rp27.000"
    When owner ubah saldo to "Rp6.000"
    Then validate detail tagihan saldo mamiads "6.000"

  @TEST_LIMO-274
   Scenario: Beli Saldo - Transaction Success
    And owner click bayar sekarang in detail tagihan for saldo mamiads
    Then payment owner success using ovo as payment method