@LIMO7 @regression @voucher @TEST_SS-3733
Feature: Tenant Apply Invalid Kost Voucher

  @continue
  Scenario: Admin Activate Voucher AUTOKOSTINV
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with id name and "apply" it to kost:
      | voucher name stag | voucher name prod | voucher id stag | voucher id prod | kost name stag | kost name prod                                   |
      | AUTOKOSTINV       | AUTOKOSTINV       | 74839           | 74839           | Kost Reykjavik | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
    Then admin can see message voucher is updated

  @continue
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

  @continue
  Scenario: Admin Deactivate Voucher AUTOKOSTINV
    Given admin go to mamikos mamipay admin
    And admin edit voucher with id name and "not apply" it to kost:
      | voucher name stag | voucher name prod | voucher id stag | voucher id prod | kost name stag | kost name prod                                   |
      | AUTOKOSTINV       | AUTOKOSTINV       | 74839           | 74839           | Kost Reykjavik | Kost Adi Auto SinggahSini Tobelo Halmahera Utara |
    Then admin can see message voucher is updated

  @continue
  Scenario: Tenant Use Invalid Voucher AUTOKOSTINV For The Kost
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    Then tenant can not use the voucher

  Scenario: Tenant Remove Invalid Voucher
    When tenant remove voucher by toast message
    Then tenant can see voucher is deleted