@regression @mamipoinTenant @BBM3 @sabtu

Feature: Tenant Apply MamiPoin on Invoice

  @TEST_BBM-379 @TEST_BBM-383 @TEST_BBM-377 @TEST_BBM-375
  Scenario: Tenant Apply MamiPoin
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321215 | 0890867321215 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    And user clicks on mamipoin toggle button to ON
    Then system display remaining payment "after" use mamipoin for payment monthly
    When user clicks on mamipoin toggle button to OFF
    Then system display remaining payment "before" use mamipoin for payment monthly

  @TEST_BBM-378
  Scenario: Point Estimate on Blackisted Tenant
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321216 | 0890867321216 | mamikosqa123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant set active page to 1
    Then tenant point estimate not displayed on invoice
