@regression @BBM4 @voucher

@TEST_BBM-628 @TEST_BBM-652 @TEST_BBM-757
Feature: Apply Voucher For Kost City

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

  @BBM-628
  Scenario: Tenant Input Voucher AUTOCITY
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
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

  @BBM-652 @BBM-757
  Scenario: Tenant can't input Voucher AUTOCITY
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321217 | 0890867321217 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOCITY          | AUTOCITY          |
    Then tenant can see warning message "Kode voucher tidak bisa digunakan."