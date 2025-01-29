@COOP3
Feature: Mamipoin Tenant Landing Page

  @SS-5060 @fail
  Scenario: MamiPoin Tenant Landing Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0810000008 | 0890867321215 | qwerty123 |
    And user navigate to kost saya page
    And user clicks on mamipoin tenant entry point button
    And user verify informasi poin button is displayed
    And user verify riwayat poin button is displayed
    And user verify dapatkan poin button is displayed
    And user verify expired point information on mamipoin landing page "2.000 poin kedaluwarsa pada 31 Mei 2025"

  @SS-5061
  Scenario: Information about points that will expire and Tenant has no point
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And user navigate to kost saya page
    And user clicks on mamipoin tenant entry point button
    Then user verify expired point information on mamipoin landing page "Tidak ada poin yang tersedia"

  @SS-5062
  Scenario: MamiPoin display on user without Poin
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890867321220 | 0890867321220 | mamikosqa123 |
    And user navigate to tagihan kost saya
    And tenant go to invoice page
    Then user will see display MamiPoin with text "Poin kamu masih 0. Yuk, bayar dulu dan dapatkan poinnya."
		
