@LIMO8 @regression @TEST_SS-3739
Feature: Invalid Voucher After Applied, Invalid Minimum Transaction

  @continue
  Scenario: Admin Set Voucher AUTOMINTRX Minimum Transaction To 500000
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set minimum transaction:
      | voucher name stag | voucher name prod | minimum transaction |
      | AUTOMINTRX        | AUTOMINTRX        | 500000              |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOMINTRX        | AUTOMINTRX        |

  @continue
  Scenario: Tenant Use Voucher AUTOMINTRX
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOMINTRX        | AUTOMINTRX        |
    Then tenant can see voucher is applied

  @continue
  Scenario: Admin Set AUTOMINTRX Minimum Transaction To 11000000
    Given admin go to mamikos mamipay admin
    And admin edit voucher with name and set minimum transaction:
      | voucher name stag | voucher name prod | minimum transaction |
      | AUTOMINTRX        | AUTOMINTRX        | 11000000            |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOMINTRX        | AUTOMINTRX        |

  @continue
  Scenario: Tenant Use Invalid Voucher AUTOMINTRX
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use voucher with message "Belum mencapai minimal transaksi. "

  Scenario: Tenant Remove Voucher AUTOMINTRX
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted