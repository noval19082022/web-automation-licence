@LIMO8 @regression @TEST_SS-3745
Feature: Invalid Voucher After Applied, Invalid Email Target

  @continue
  Scenario: Admin Apply AUTOTARGINV With Target Email
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and "apply" target email:
      | voucher name stag | voucher name prod | target email             |
      | AUTOTARGINV       | AUTOTARGINV       | adivouchersatu@gmail.com |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOTARGINV       | AUTOTARGINV       |

  @continue
  Scenario: Tenant Use Voucher AUTOPROFESSION
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOTARGINV       | AUTOTARGINV       |
    Then tenant can see voucher is applied

  @continue
  Scenario: Admin Not Apply AUTOTARGINV With Target Email
    Given admin go to mamikos mamipay admin
    And admin edit voucher with name and "not apply" target email:
      | voucher name stag | voucher name prod | target email             |
      | AUTOTARGINV       | AUTOTARGINV       | adivouchersatu@gmail.com |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOTARGINV       | AUTOTARGINV       |

  @continue
  Scenario: Tenant Use Invalid Voucher AUTOTARGINV
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use the voucher

  Scenario: Tenant Remove Voucher AUTOTARGINV
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted