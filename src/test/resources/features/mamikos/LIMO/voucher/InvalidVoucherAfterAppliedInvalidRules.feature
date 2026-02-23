@LIMO8 @regression @TEST_SS-3741
Feature: Invalid Voucher After Applied, Invalid Rules

  @continue
  Scenario: Admin Activate Voucher AUTORULES
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set payment rules:
      | voucher name stag | voucher name prod | voucher rule  |
      | AUTORULES         | AUTORULES         | For Recurring |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTORULES         | AUTORULES         |

  @continue
  Scenario: Tenant Use Voucher AUTORULES
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTORULES         | AUTORULES         |
    Then tenant can see voucher is applied

  @continue
  Scenario: Admin Deactivate Voucher AUTORULES
    Given admin go to mamikos mamipay admin
    And admin edit voucher with name and unset payment rules:
      | voucher name stag | voucher name prod | voucher rule  |
      | AUTORULES         | AUTORULES         | For Recurring |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTORULES         | AUTORULES         |

  @continue
  Scenario: Tenant Use Invalid Voucher AUTORULES
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use the voucher

  Scenario: Tenant Remove Voucher AUTORULES
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted