@regression @voucher @LIMO7

@TEST_SS-3807
Feature: Apply Voucher For Invoice Meet Minimal Contract Duration

  Scenario: Invoice Yearly and Voucher For Quarterly
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOSUGGESTION    | AUTOQUARTERLY     |
    Then tenant can see voucher is applied