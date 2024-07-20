@COOP-5027 @COOP3
Feature: Mamipoin Tenant Entry Point

  @SS-5054
  Scenario: MamiPoin Tenant Entry Point When the User is Blacklisted
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321216 | 0890867321216 | mamikosqa123 |
    And user navigate to kost saya page
    Then user verify mamipoin tenant entry point is not displayed

  @SS-5055
  Scenario: MamiPoin Tenant Entry Point When the User is Whitelisted
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0892202108 | 0890867321215 | qwerty123 |
    And user navigate to kost saya page
    And user verify the amount of poin owned by the tenant is "279"
    And user clicks on mamipoin tenant entry point button
    Then user verify title in the mamipoin tenant landing page is displayed

  @SS-5056
  Scenario: MamiPoin Tenant Entry Point When the User Poin is Empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And user navigate to kost saya page
    And user verify the amount of poin owned by the tenant is "0"
    And user clicks on mamipoin tenant entry point button
    Then user verify title in the mamipoin tenant landing page is displayed
		
