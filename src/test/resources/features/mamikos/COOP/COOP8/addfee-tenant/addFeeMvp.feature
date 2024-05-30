@BBM8 @addFeeMvp
Feature: Add fee Mvp - Tenant

  Scenario: Teminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag     | phone prod     |
      | 08100000213    | 08100000213    |

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
    And tenant click on pilih tambahan on booking form
    Then tenant can see "Bawa Televisi" on booking form
    When tenant can see "Parkir Motor" on booking form
    Then tenant cant see "Benefit Asuransi & Biaya Admin" on booking form
    And tenant click on save button

#  @TEST_COOP-6956
    And tenant click on pilih tambahan on booking form
    When tenant choose biaya tambahan "Bawa Televisi" on booking form
    Then tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    Then tenant can see "Bawa Televisi, Parkir Motor" on booking form

#  @TEST_COOP-6957
    When tenant click on ubah tambahan barang on booking form
    And tenant choose biaya tambahan "Bawa Kulkas" on booking form
    And tenant click on save button
    Then tenant can see "Bawa Televisi, Parkir Motor, Bawa Kulkas" on booking form

   @TEST_COOP-6962 @continue
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

  @TEST_COOP-6961 @TEST_COOP-6958 @continue
  Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if choose additional fee but don't have note
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                |
      | Kost Scenario Sepuluh Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Tambahan barang dan fasilitas" on booking form
    And tenant click on pilih tambahan on booking form
    When tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    Then tenant can see "Parkir Motor" on booking form
    And user can set Ajukan Sewa
    Then tenant should success booking kost
    And tenant click on chat pemilik
    Then tenant can see tenant description with "Parkir Motor"

  @TEST_COOP-6959 @continue
  Scenario:  [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if you choose add the cost and write
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                |
      | Kost Scenario Sepuluh Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And tenant click on pilih tambahan on booking form
    When tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    And tenant input catatan tambahan with "Saya bawa kucing meong-meong"
    And user can set Ajukan Sewa
    Then tenant should success booking kost
    And tenant click on chat pemilik
    Then tenant can see tenant description with "Parkir Motor dan Saya bawa kucing meongmeong"

   @TEST_COOP-6960 @continue
   Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if not choose extra charge but have note
     When user go to mamikos homepage
     And user cancel booking
     And user go to mamikos homepage
     And tenant search kost then go to kost details:
       | kost name stag                |
       | Kost Scenario Sepuluh Balik Bukit Lampung Barat  |
     And tenant dismiss promo ngebut pop up
     And tenant booking kost for "Tomorrow"
     And tenant input catatan tambahan with "Saya bawa kucing meongmeong"
     And user can set Ajukan Sewa
     Then tenant should success booking kost
     And tenant click on chat pemilik
     Then tenant can see tenant description with "Saya bawa kucing meongmeong"

  @TEST_COOP-6988
  Scenario: [Booking form][Autofill Note] Simpan draft when select catatan tambahan and input permintaan ke pemilik text
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                                        |
      | Kost Scenario Sepuluh Balik Bukit Lampung Barat  |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And tenant click on pilih tambahan on booking form
    When tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    And tenant input catatan tambahan with "Saya bawa kucing meong-meong"
    And user click back button
    And user click Save Draft Button
    And tenant navigate to riwayat and draf booking
    And user click on Draft menu
    And tenant click ajukan sewa text button on draft
    Then tenant can see "Tambahan barang dan fasilitas" on booking form