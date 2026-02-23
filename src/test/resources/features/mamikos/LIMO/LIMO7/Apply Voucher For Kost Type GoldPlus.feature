@regression @LIMO8 @voucher

@TEST_SS-3721 @TEST_SS-3732 @TEST_SS-3738 @TEST_SS-3761 @TEST_SS-3763 @TEST_SS-3764
Feature: Apply Voucher For Kost Type GoldPlus

  @continue
  Scenario: Tenant Apply Voucher Applicable for Kost Type GoldPlus 1
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321221 | 0890867321221 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOGP1           | AUTOGP1           |
    Then tenant can see voucher is applied

  @continue
  Scenario: Tenant Apply Voucher Not Applicable for Kost Type GoldPlus 1
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVNAGP1        | AUTOVNAGP1        |
    Then Voucher code has been used

  @continue
  Scenario: Tenant Apply Voucher Applicable for Kost City
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOKOSTCITY      | AUTOKOSTCITY      |
    Then tenant can see voucher is applied

  Scenario: Tenant Apply Voucher Not Applicable for Kost City
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVNAKOSTCITY   | AUTOVNAKOSTCITY   |
    Then Voucher code has been used