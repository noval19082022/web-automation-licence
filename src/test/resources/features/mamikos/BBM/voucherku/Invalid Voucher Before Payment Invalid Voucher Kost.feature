@voucher
Feature: Tenant Apply Invalid Kost Voucher

  Scenario: Admin Activate Voucher AUTOKOSTINV
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher and "apply" it to kost:
      | voucher name stag | voucher name prod | kost name stag            | kost name prod            |
      | AUTOKOSTINV       | AUTOKOSTINV       | Kost Adi Auto SinggahSini | Kost Adi Auto SinggahSini |
    Then admin can see message voucher is updated

  Scenario: Tenant Use Voucher AUTOKOSTINV
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOKOSTINV       | AUTOKOSTINV       |
    Then tenant can see voucher is applied