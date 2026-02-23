@LIMO7
Feature: Invalid Voucher After Applied, Voucher Is Inactive

  @TEST_SS-4270
  Scenario: Activate Voucher AUTOVINVALID
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu
    And admin input voucher with value "AUTOVINVALID" and click search button:
    And admin activate mass voucher
    Then System display alert message on mamipay web

  Scenario: Tenant Input Voucher AUTOVINVALID
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVINVALID      | AUTOVINVALID      |
    Then tenant can see voucher is applied

  Scenario: Deactivate Voucher AUTOVINVALID
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu
    And admin input voucher with value "AUTOVINVALID" and click search button:
    And admin deactivate mass voucher
    Then System display alert message on mamipay web

  Scenario: Tenant can't Input Voucher AUTOVINVALID
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVINVALID      | AUTOVINVALID      |
    Then tenant can see warning message "Kode voucher tidak ditemukan."
		
