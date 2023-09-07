@regression @BBM4 @voucher

Feature: Voucher Suggestion
  @TEST_BBM-475 @TEST_BBM-476 @TEST_BBM-477 @TEST_BBM-478 @TEST_BBM-700 @TEST_BBM-708
  Scenario: Tenant have any eligible voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOSUGGESTION    | AUTOSUGGESTION       |
    Then tenant can see voucher is applied
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | TENGSALAH         | TENGSALAH |
    Then tenant display warning message "Kode voucher tidak ditemukan."

    #    BBM-708
  Scenario: Tenant don't have any eligible voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321220 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And user click on "Bayar" button
    And tenant set active page to 1
    Then tenant can see voucher suggestion empty state

