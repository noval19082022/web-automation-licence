@regression @mamipoinTenant @BBM3

Feature: MamiPoin Tenant Landing Page

  @TEST_BBM-418 @TEST_BBM-411 @TEST_BBM-408 @TEST_BBM-406 @TEST_BBM-407
  Scenario: MamiPoin Tenant Landing Page
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0892202108 | 0890867321215 | qwerty123 |
    And user navigate to kost saya page
    And user clicks on mamipoin tenant entry point button
    And user verify informasi poin button is displayed
    And user verify riwayat poin button is displayed
    And user verify dapatkan poin button is displayed
    And user verify expired point information on mamipoin landing page "1.600 poin kedaluwarsa pada 30 Nov 2023"

#  @TEST_BBM-420
#  Scenario: Information about points that will expire and Tenant has no point
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag    | phone prod    | password     |
#      | 0890867321220 | 0890867321220 | mamikosqa123 |
#    And user navigate to kost saya page
#    And user clicks on mamipoin tenant entry point button
#    Then user verify expired point information on mamipoin landing page "Tidak ada poin yang tersedia"
#
#  @TEST_BBM-384
#  Scenario: MamiPoin display on user without Poin
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag    | phone prod    | password     |
#      | 0890867321220 | 0890867321220 | mamikosqa123 |
#    And user navigate to tagihan kost saya
#    And tenant go to invoice page
#    Then user will see display MamiPoin with text "Poin kamu masih 0. Yuk, bayar dulu dan dapatkan poinnya."