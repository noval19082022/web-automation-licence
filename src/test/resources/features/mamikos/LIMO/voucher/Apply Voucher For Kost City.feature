@LIMO7
Feature: Apply Voucher For Kost City

  @TEST_SS-4260
  Scenario: Activate Voucher AUTOCITY
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set voucher aplicable on city:
      | voucher name stag | voucher name prod | voucher City              |
      | AUTOCITY          | AUTOCITY          | Kabupaten Halmahera Utara |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOCITY          | AUTOCITY          |

  @SS-628
  Scenario: Tenant Input Voucher AUTOCITY
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCITY          | AUTOCITY          |
    Then tenant can see voucher is applied

  Scenario: Deactivate voucher AUTOCITY
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin edit voucher with name and set voucher not aplicable on city:
      | voucher name stag | voucher name prod | voucher City              |
      | AUTOCITY          | AUTOCITY          | Kabupaten Halmahera Utara |
    Then admin can see below voucher is updated:
      | voucher name stag | voucher name prod |
      | AUTOCITY          | AUTOCITY          |

  @SS-652 @SS-757
  Scenario: Tenant can't input Voucher AUTOCITY
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCITY          | AUTOCITY          |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."