@LIMO8 @regression @TEST_SS-3722 @TEST_SS-3725 @TEST_SS-3726 @TEST_SS-3844
Feature: Apply Voucher For Kost Type Verified By Mamichecker

  @continue
  Scenario: Invoice Verified By Mamichecker and Voucher Applicable for Verified By Mamichecker
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321222 | 0890867321222 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOMAMICHECK     | AUTOMAMICHECK     |
    Then tenant can see mamirooms voucher is applied

  Scenario: Invoice Verified By Mamichecker and Voucher Not Applicable for Verified By Mamichecker
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | VNAMAMICHECK      | VNAMAMICHECK      |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."