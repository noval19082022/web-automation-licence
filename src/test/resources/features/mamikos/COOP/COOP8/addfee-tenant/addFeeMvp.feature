@COOP8 @addFeeMvp
Feature: Add fee Mvp - Tenant

  @TEST-COOP-6954 @continue
  Scenario: [Tenant][Detail booking]  for P2 in the kos details there is no order form
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | password |
      | 08100000213 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                                        |
      | Kosan Geng Keju Swiss Cheese Gondokusuman Yogyakarta  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant cant see "Tambahan barang dan fasilitas" on booking form
    When tenant can see "catatan tambahan" on booking form
    And tenant input catatan tambahan with "hallo saya automation dan bawa kucing meong meong"
    Then tenant can see allert addfee

  @TEST-COOP-6953
  Scenario: [Tenant][Detail booking]  Check for kost p1 doesnt have addfee kk
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                |
      | Kost Scenario Delapan Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant cant see "Tambahan barang dan fasilitas" on booking form
    When tenant can see "catatan tambahan" on booking form
    And tenant input catatan tambahan with "hallo saya automation dan bawa kucing meong meong"
    Then tenant can see allert addfee