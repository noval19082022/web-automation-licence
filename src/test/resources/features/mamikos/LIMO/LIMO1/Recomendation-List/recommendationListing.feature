@LIMO1 @DONEMIGRATINGTONEWBOARD
Feature: Recommendation Listing

  @TEST_LIMO-2711
  Scenario: Tenant never lihat detail properti
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password  |
      | 0812233445566 | qwerty123 |
    Then verify message "Belum ada kos yang di favorit." di Favorit page
    And verify no rekomendasi on kos saya page
    And tenant logs out

#  @TEST_LIMO-2712
#  Scenario: There is no recommendation
#    Given user go to mamikos homepage
#    And user login as tenant via phone number:
#      | phone stag    | password  |
#      | 0827777777774 | qwerty123 |
##    When tenant search kost then go to apartment details:
##      | kost name stag | kost name prod |
##      | Silalay 123    |                |
#    And tenant redirect to kost details:
#      | kost path stag                                       | kost path prod               |
#      | unit/apartemen-kalibata-city/silalay-123-1room-studio-1 | Kos DC BAR Automation Tipe A |
#    Then tenant open tab pernah dilihat at menu favorite
#    And tenant verify the property with name "Silalay" is appear
#    And tenant verify the Hapus History button is appear
#    When tenant open tab difavoritkan at menu favorite
#    Then user verify rekomendasi listing section didn't display
#    And verify no rekomendasi on kos saya page

  @TEST_LIMO-2713
  Scenario: There is no recommendation booking cancel
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | password  |
      | 082322233399 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                              | kost path prod               |
      | kost-yogyakarta-kost-putri-eksklusif-kos-upik-merapi-tipe-c | Kos DC BAR Automation Tipe A |
    And tenant booking kost "tomorrow" "Per Bulan"
    Then tenant should success booking kost
    When user cancel booking
    Then tenant check status booking is "Dibatalkan"

  @TEST_LIMO-2714
  Scenario Outline: Check recommendation section at favorite page and kos saya page
    Given user go to mamikos homepage
    And user login as tenant via phone number:
      | phone stag    | password   |
      | <tenantPhone> | <password> |
    And tenant redirect to kost details:
      | kost path stag                                                                         | kost path prod               |
      | kost-kota-yogyakarta-kost-putri-eksklusif-kos-raney-momogi-tipe-a-danurejan-yogyakarta | Kos DC BAR Automation Tipe A |
    When tenant open tab pernah dilihat at menu favorite
    And tenant verify the property with name "Kos Raney Momogi Tipe A" is appear
    And tenant verify the Hapus History button is appear
    When tenant open tab difavoritkan at menu favorite
    #And do validation rekomendasi "<validation>" with maximal <countPerPage> per page and maximal page is <countPage>
    Then user verify rekomendasi listing section is displayed
    And user verify the rekomendasi listing max is 2 page
    And user verify the max 8 rekomendasi listing
    #MA-5289-Make sure rekomendasi on kos saya max 8 properti (MA-5289)
    And do validation rekomendasi "<validation>" on "Kos Saya" page
    And user verify the rekomendasi listing max is <countPerPage> page
    And user verify the max <maxPage> rekomendasi listing
    Examples:
      | tenantPhone   | password     | validation    | countPerPage | maxPage |
      | 0828888888880 | qwerty123    | displayed     | 4            | 8       |
      | 0890000000325 | Bismillah@01 | not displayed | 0            | 0       |

  @TEST_LIMO-2715 @continue @favRekomendasi
  Scenario: Check property recommendation section after favorite
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | password  |
      | 0892202413 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag             | kost name prod |
      | Kos Raney Aphrodite Tipe 3 |                |
    When tenant open menu favorite
    Then verify last seen property display on rekomendasi section

  @TEST_LIMO-2716
  Scenario: Verify kost is show at rekomendation section after unfavorite kost
    #unfavorite kost
    When tenant open tab pernah dilihat at menu favorite
    And user can unfavorite the kost for recomendation listing
    And user click on hapus histori button
    Then user can verify kost after unfavorite the kost

  @TEST_LIMO-1452
  Scenario: Make sure If tenant click back button, then tenant will be redirected back to Detail Booking screen
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | password  |
      | 082322233399 | qwerty123 |
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                              | kost path prod               |
      | kost-kabupaten-tangerang-kost-campur-murah-kos-digitec-male-rajeg-tangerang | Kos DC BAR Automation Tipe A |
    And tenant booking kost "tomorrow" "Per Bulan"
    Then tenant should success booking kost
    And user cancel booking for check recommendation kos
    And owner click back previous button
    Then tenant check status booking is "Dibatalkan"