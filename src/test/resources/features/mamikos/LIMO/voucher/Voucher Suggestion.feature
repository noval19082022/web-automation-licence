@SS-5843 @LIMO7
Feature: Voucher Suggestion

  @TEST_SS-4280
  Scenario: Tenant have any eligible voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0890867321217 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | AUTOSUGGESTION    | AUTOSUGGESTION    |
    Then tenant can see voucher is applied
    And tenant apply voucher:
      | voucher name stag | voucher name prod |
      | TENGSALAH         | TENGSALAH         |
    Then tenant display warning message "Kode voucher tidak ditemukan."

  Scenario: Tenant don't have any eligible voucher
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod  | password     |
      | 0890867321220 | 08100000622 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see voucher suggestion empty state
		
