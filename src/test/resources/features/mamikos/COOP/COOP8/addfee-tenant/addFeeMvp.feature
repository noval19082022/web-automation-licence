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

  @TEST-COOP-6953 @continue
  Scenario: [Tenant][Detail booking]  Check for kost p1 doesnt have addfee kk
    Given user go to mamikos homepage
    When user cancel booking
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                   |
      | Kost Scenario Delapan Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant cant see "Tambahan barang dan fasilitas" on booking form
    When tenant can see "catatan tambahan" on booking form
    And tenant input catatan tambahan with "hallo saya automation dan bawa kucing meong meong"
    Then tenant can see allert addfee

  @TEST-COOP-6955 @continue @TEST_COOP-6956 @TEST_COOP-6957
  Scenario: [Tenant][Detail booking]  Tenant see optional biaya tambahan from PMS-KK
    When user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                |
      | Kost Scenario Sepuluh Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Tambahan barang dan fasilitas" on booking form
    And tenant click on "Pilih tambahan" on booking form
    Then tenant can see "Bawa Televisi" on booking form
    When tenant can see "Parkir Motor" on booking form
    Then tenant cant see "Benefit Asuransi & Biaya Admin" on booking form
    And tenant click on save button

#  @TEST_COOP-6956
    And tenant click on "Pilih tambahan" on booking form
    When tenant choose biaya tambahan "Bawa Televisi" on booking form
    Then tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    Then tenant can see "Bawa Televisi, Parkir Motor" on booking form

#  @TEST_COOP-6957
    When tenant click on "Ubah tambahan" on booking form
    And tenant choose biaya tambahan "Bawa Kulkas" on booking form
    And tenant click on save button
    Then tenant can see "Bawa Televisi, Parkir Motor, Bawa Kulkas" on booking form

   @TEST_COOP-6962
   Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if not choose extra fee and don't write a note
     When user go to mamikos homepage
     And user cancel booking
     When user go to mamikos homepage
     And tenant search kost then go to kost details:
       | kost name stag                                   |
       | Kost Scenario Delapan Balik Bukit Lampung Barat  |
     And tenant dismiss promo ngebut pop up
     And tenant booking kost for "Tomorrow"
     And user can set Ajukan Sewa
     Then tenant should success booking kost
     And tenant click on chat pemilik
     Then tenant can see tenant description with "-"