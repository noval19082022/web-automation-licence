@LIMO7 @regression @TEST_hSS-3748
Feature: Invalid Voucher After Applied, Invalid Profession

  @continue
  Scenario: Activate voucher AUTOPROFESSION
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set profession:
      | voucher name stag | voucher name prod | profession |
      | AUTOPROFESSION    | AUTOPROFESSION    | mahasiswa  |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOPROFESSION    | AUTOPROFESSION    |

  @continue
  Scenario: Tenant Use Voucher AUTOPROFESSION
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321221 | 0890867321221 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOPROFESSION    | AUTOPROFESSION    |
    Then tenant can see voucher is applied

  @continue
  Scenario: Admin Deactivate Voucher AUTOPROFESSION
    Given admin go to mamikos mamipay admin
    And admin edit voucher with name and set profession:
      | voucher name stag | voucher name prod | profession |
      | AUTOPROFESSION    | AUTOPROFESSION    | karyawan   |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOPROFESSION    | AUTOPROFESSION    |

  @continue
  Scenario: Tenant Use Invalid Voucher AUTOPROFESSION
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use the voucher

  Scenario: Tenant Remove Voucher AUTOPROFESSION
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted