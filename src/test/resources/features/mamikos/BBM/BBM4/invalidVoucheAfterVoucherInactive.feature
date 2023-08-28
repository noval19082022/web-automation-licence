@regression @BBM4 @voucher

@TEST_BBM-750
Feature: Invalid Voucher After Applied, Voucher Is Inactive

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
      | phone stag  | phone prod  | password  |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
    When tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOVINVALID | AUTOVINVALID |
    Then tenant can see voucher is applied

  Scenario: Deactivate Voucher AUTOVINVALID
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigate to mamikos voucher menu
    And admin input voucher with value "AUTOVINVALID" and click search button:
    And admin activate mass voucher
    Then System display alert message on mamipay web

  Scenario: Hapus Button Functionality on Toast Message
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
    When tenant set active page to 1
    Then tenant can not use the voucher
    And tenant remove voucher by toast message