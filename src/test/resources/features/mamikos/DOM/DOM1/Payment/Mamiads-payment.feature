Feature: Payment mamiads staging

  @TEST_COOP-4469
  Scenario: [Owner][Payment premium] Owner paid premium paket using Alfamart
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment using alfamart xendit as payment method from invoice detail
    Then owner will see that the text "Pembayaran Berhasil" is displayed

   @continue @TEST_COOP_4641
  Scenario: [Owner][Payment premium] Owner paid premium paket using Permata
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod  | password  |
      | 08123450977 | 08123450977 | qwerty123 |
    And owner want to buy mamiads saldo with nominal "Rp27.000"
    And owner select payment method using "PERMATA"
    Then owner verify invoice success paid mamiads