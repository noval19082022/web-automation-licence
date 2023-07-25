@regression @mamipoinTenant @BBM3

Feature: MamiPoin Tenant Entry Point

  @TEST_BBM-415
  Scenario: MamiPoin Tenant Entry Point When the User is Blacklisted
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321216 | 0890867321216 | mamikosqa123 |
    And user navigate to kost saya page
    Then user verify mamipoin tenant entry point is not displayed

  @TEST_BBM-470
  Scenario: MamiPoin Tenant Entry Point When the User is Whitelisted
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321215 | 0890867321215 | mamikosqa123 |
    And user navigate to kost saya page
    And user verify the amount of poin owned by the tenant is "1.000"
    And user clicks on mamipoin tenant entry point button
    Then user verify title in the mamipoin tenant landing page is displayed

  @TEST_BBM-424
  Scenario: MamiPoin Tenant Entry Point When the User Poin is Empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And user navigate to kost saya page
    And user verify the amount of poin owned by the tenant is "0"
    And user clicks on mamipoin tenant entry point button
    Then user verify title in the mamipoin tenant landing page is displayed

