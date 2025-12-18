@SS10 @addFeeMvp
Feature: Add fee Mvp - Tenant

  Scenario: Teminated contract
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then admin search contract by tenant phone number and akhiri contract:
      | phone stag  | phone prod  |
      | 08100000213 | 08100000213 |

  @TEST-SS-2709 @continue
  Scenario: [Tenant][Detail booking]  for P2 in the kos details there is no order form
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | password  |
      | 08100000213 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                                               | kost path prod               |
      | kost-kabupaten-sleman-kost-campur-eksklusif-automation-limo-limo-2727-depok-sleman | Kos DC BAR Automation Tipe A |
    And tenant dismiss FTUE booking benefit
    And tenant booking kost for "Tomorrow"
    Then tenant cant see "Tambahan barang dan fasilitas" on booking form
    When tenant can see "catatan tambahan" on booking form
    And tenant input catatan tambahan with "hallo saya automation dan bawa kucing meong meong"
    Then tenant can see allert addfee

  @TEST-SS-2708 @continue
  Scenario: [Tenant][Detail booking]  Check for kost p1 doesnt have addfee kk
    Given user go to mamikos homepage
    When user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-delapan-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant cant see "Tambahan barang dan fasilitas" on booking form
    When tenant can see "catatan tambahan" on booking form
    And tenant input catatan tambahan with "hallo saya automation dan bawa kucing meong meong"
    Then tenant can see allert addfee

  @TEST-SS-2710 @continue @TEST_SS-2711 @TEST_SS-2712
  Scenario: [Tenant][Detail booking]  Tenant see optional biaya tambahan from PMS-KK
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-sepuluh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
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

  @TEST_SS-2714 @continue
  Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if not choose extra fee and don't write a note
    When tenant navigate to riwayat and draf booking
    And user cancel booking
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-delapan-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And user can set Ajukan Sewa
    Then tenant should success booking kost
    And tenant click on chat pemilik
    Then tenant can see tenant description with "-"

  @TEST_SS-2713 @continue
  Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if choose additional fee but don't have note
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-sepuluh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    Then tenant can see "Tambahan barang dan fasilitas" on booking form
    And tenant click on pilih tambahan on booking form
    When tenant choose biaya tambahan "Parkir Motor" on booking form
    And tenant click on save button
    Then tenant can see "Parkir Motor" on booking form
    And tenant input catatan tambahan with ""
    And user can set Ajukan Sewa
    Then tenant should success booking kost
    And tenant click on chat pemilik
    Then tenant can see tenant description with "Parkir Motor"

  @TEST_SS-4286 @continue
  Scenario:  [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if you choose add the cost and write
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-sepuluh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
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

  @TEST_SS-4286 @continue
  Scenario: [Tenant][Detail booking]  After the tenant ajukan sewa, chat will be sent to Rajawali  - if not choose extra charge but have note
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-sepuluh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
    And tenant dismiss promo ngebut pop up
    And tenant booking kost for "Tomorrow"
    And tenant input catatan tambahan with "Saya bawa kucing meongmeong"
    And user can set Ajukan Sewa
    Then tenant should success booking kost
    And tenant click on chat pemilik
    Then tenant can see tenant description with "Saya bawa kucing meongmeong"

  @TEST_SS-4287
  Scenario: [Booking form][Autofill Note] Simpan draft when select catatan tambahan and input permintaan ke pemilik text
    When user go to mamikos homepage
    And user cancel booking
    And user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                                         | kost path prod               |
      | kost-kost-campur-murah-kost-scenario-sepuluh-balik-bukit-lampung-barat | Kos DC BAR Automation Tipe A |
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