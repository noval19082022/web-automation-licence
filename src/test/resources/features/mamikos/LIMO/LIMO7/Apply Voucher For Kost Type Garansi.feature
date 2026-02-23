@regression @LIMO7 @voucher

@TEST_SS-3729 @TEST_SS-3731 @TEST_SS-4001 @TEST_SS-4003
Feature: Apply Voucher For Kost Type Garansi

  @continue
  Scenario: Tenant Apply Voucher Applicable for Kost Type Garansi
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321221 | 0890867321221 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOGARANSI       | AUTOGARANSI       |
    Then tenant can see voucher is applied

#    COOP-2928
  Scenario: Tenant Apply Voucher Not Applicable for Kost Type Garansi
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVNAGARANSI    | AUTOVNAGARANSI    |
    Then Voucher code has been used