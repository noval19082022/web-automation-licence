@regression @BBM7 @voucher

@TEST_BBM-679 @TEST_BBM-683
Feature: Apply Voucher For Kost Type Mamirooms

  Scenario: Invoice Mamirooms and Voucher Applicable for Mamirooms
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag     |  phone prod        | password      |
      | 0890867321222  |  0890867321222     | mamikosqa123  |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOMAMIROOM       | AUTOMAMIROOM     |
    Then tenant can see voucher is applied

    #BBM-683
  Scenario: Invoice Mamirooms and Voucher Not Applicable for Mamirooms
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVNAMAMIROOM   | AUTOVNAMAMIROOM   |
    Then Voucher code has been used