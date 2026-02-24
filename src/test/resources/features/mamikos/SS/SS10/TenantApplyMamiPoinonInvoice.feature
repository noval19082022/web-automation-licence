@regression @mamipoinTenant @SS8

Feature: Tenant Apply MamiPoin on Invoice

  @TEST_SS-3595 @TEST_SS-4276 @TEST_SS-3597 @TEST_SS-3594 @TEST_SS-3979
  Scenario: Tenant Apply MamiPoin
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000006 | 0812000006 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant can see disable mamipoin button

  @TEST_SS-3575
  Scenario: Point Estimate on Blackisted Tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0812000004 | 0812000004 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant point estimate not displayed on invoice
