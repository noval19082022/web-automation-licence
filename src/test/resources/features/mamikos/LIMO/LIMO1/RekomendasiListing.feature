@regression @LIMO1 @LIMO1-staging
Feature: Rekomendasi Listing

  @TEST_LIMO-305
  Scenario: Tenant never lihat detail properti
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password  |
      | 0812233445566 | qwerty123 |
    Then verify message "Belum ada kos yang di favorit." di Favorit page
    And verify no rekomendasi on kos saya page

  @TEST_LIMO-302
  Scenario: There is no rekomendasi
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password  |
      | 0827777777774 | qwerty123 |
    When tenant search kost then go to apartment details:
      | kost name stag | kost name prod |
      | Silalay 123    |                |
    Then tenant open tab pernah dilihat at menu favorite
    And tenant verify the property with name "Silalay 123" is appear
    And tenant verify the Hapus History button is appear
    When tenant open tab difavoritkan at menu favorite
    Then user verify rekomendasi listing section didn't display
    And verify no rekomendasi on kos saya page

  @TEST_LIMO-301
  Scenario: There is no rekomendasi booking cancel
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password    |
      | 0890000000265 | Bismillah01 |
    When tenant search kost then go to kost details:
      | kost name stag         | kost name prod |
      | Kos Upik Merapi Tipe C |                |
    And tenant booking kost "tomorrow" "Per Bulan"
    Then tenant should success booking kost
    And user cancel booking
    Then tenant check status booking is "Dibatalkan"

  @TEST_LIMO-304 @TEST_LIMO-303
  Scenario Outline: Rekomendasi page is appear when tenant have contract booking active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password   |
      | <tenantPhone> | <password> |
    When tenant search kost then go to kost details:
      | kost name stag          | kost name prod |
      | Kos Raney Momogi Tipe A |                |
    Then tenant open tab pernah dilihat at menu favorite
    And tenant verify the property with name "Kos Raney Momogi Tipe A Danurejan Yogyakarta" is appear
    And tenant verify the Hapus History button is appear
    When tenant open tab difavoritkan at menu favorite
#   And do validation rekomendasi "<validation>" with maximal <countPerPage> per page and maximal page is <countPage>
    Then user verify rekomendasi listing section is displayed
    And user verify the rekomendasi listing max is 2 page
    And user verify the max 8 rekomendasi listing
    #MA-5289-Make sure rekomendasi on kos saya max 8 properti (MA-5289)
    And do validation rekomendasi "<validation>" on kos saya page
    And user verify the rekomendasi listing max is <countPerPage> page
    And user verify the max <maxPage> rekomendasi listing
    Examples:
      | tenantPhone   | password     | validation    | countPerPage | maxPage |
      | 0828888888880 | qwerty123    | displayed     | 4            | 2       |
      | 0890000000325 | Bismillah@01 | not displayed | 0            | 0       |


