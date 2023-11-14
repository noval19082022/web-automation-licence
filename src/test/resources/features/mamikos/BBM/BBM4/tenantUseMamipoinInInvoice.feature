@regression @mamipoinTenant @BBM4

Feature: Tenant use MamiPoin in Invoice

  @TEST_BBM-381
  @continue
  Scenario: Tenant use MamiPoin and Pay Invoice
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 082245500001  | 082245500001 | qwerty123 |
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And user clicks on mamipoin toggle button to ON
    And user remove voucher
#    Then user should see potongan mamipoin is 2000 and total payment is 999000

  @TEST_BBM-380
  Scenario: Tenant use MamiPoin and Voucher at the same time
    Given user go to mamikos homepage
    And tenant navigate to tagihan kost saya
    And tenant go to invoice page
    And tenant apply voucher:
      | voucher name stag     | voucher name prod   |
      | MAMIVCHTEST           | MAMIVCHTEST         |
#    Then user should see potongan mamipoin is 2000 and total payment is 989000
    And user clicks on mamipoin toggle button to OFF

