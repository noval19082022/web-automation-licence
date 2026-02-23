@LIMO8 @regression @TEST_SS-3749
Feature: Invalid Voucher After Applied, Invalid Date

  @continue
  Scenario: Activate Voucher AUTOEXPIRED
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name end date to "":
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |

  @continue
  Scenario: Tenant Use Voucher AUTOEXPIRED
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |
    Then tenant can see voucher is applied

  @continue
  Scenario: Admin Set Voucher AUTOEXPIRED End Date To Yesterday
    Given admin go to mamikos mamipay admin
    And admin edit voucher with name end date to "yesterday":
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOEXPIRED       | AUTOEXPIRED       |

  @continue
  Scenario: Tenant Use Expired Voucher AUTOEXPIRED
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use the voucher

  Scenario: Tenant Remove Voucher AUTOEXPIRED
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted