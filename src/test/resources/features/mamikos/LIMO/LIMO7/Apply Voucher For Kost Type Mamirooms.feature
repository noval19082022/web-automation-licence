@regression @LIMO8 @voucher

@TEST_SS-3803 @TEST_SS-3897 @TEST_SS-3899 @TEST_SS-3900
Feature: Apply Voucher For Kost Type Mamirooms

  @continue
  Scenario: Invoice Mamirooms and Voucher Applicable for Mamirooms
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321222 | 0890867321222 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOMAMIROOM      | AUTOMAMIROOM      |
    Then tenant can see mamirooms voucher is applied

    # COOP-2825
  Scenario: Invoice Mamirooms and Voucher Not Applicable for Mamirooms
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVNAMAMIROOM   | AUTOVNAMAMIROOM   |
    Then Voucher code has been used