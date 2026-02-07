@regression @LIMO3 @listing-monetization @createKosFromHome @DONEMIGRATINGTONEWBOARD @mantan

Feature: Create Kos From Home

#  @TEST_LIMO-913 @addKosFromUpdatePrice @skip @needsInvestigation
#  Scenario: [WEB][Owner Dashboard][Update Price] Add new kost from Dashboard (status property kos diperiksa admin/reject && status apartment diperiksa admin/reject )
#    # SKIPPED: Menu "Atur Harga" locator needs investigation - UI may have changed
#    # TODO: Manually verify the correct locator for "Atur Harga" menu on owner dashboard (For now atur harga is not exist after revamp)
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag    | password  |
#      | 0812345670010 | qwerty123 |
#    And user click menu "Atur Harga" on feature waktunya mengelola property
#    Then verify that owner not yet have active kos
#    And verify tambah kos button displayed
#    When owner create new kos
#    Then user should redirect to link "https://owner-jambu.kerupux.com/kos/create?step=1"

  @TEST_LIMO-967 @continue @createNewKos
  Scenario: [Form add New Kost][Data Kos]Check checkbox regulations kos and uploaded regulations kos with invalid value
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083128754260 | qwerty123 |
    And owner navigates to property saya kos
    And owner close pop up BBK at kos list page
    And owner click tambah data iklan "Kost"
    And owner clicks on Tambah Kos Baru button
    And owner fills valid data kos as expected
      | kos name                            | room type check | room type name | kos type | description kos                 | build kos | other note |
      | Kost Automation Test Hapus Di Akhir | yes             | Tipe A         | girl     | kos for case invalid rule photo | 2023      |            |
    And owner set rules kos:
      | Akses 24 Jam |
    And owner upload rule kos
    Then verify warning upload gagal
    When owner upload valid rule kos
    Then verify warning upload gagal disappear

  @TEST_LIMO-970 @createNewKos @continue
  Scenario: [Form add New Kost][Foto Kos]Upload photo with invalid photos
    When owner click Lanjutkan for input kos address
    And owner click on leftlet marker
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner invalid upload photo "bangunan tampak depan"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "tampilan dalam bangunan"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "tampak dari jalan"
    Then verify warning upload gagal
    When owner valid upload photo kos

  @TEST_LIMO-998 @createNewKos @continue
  Scenario:[Form add New Kost][Foto Kamar]Upload photo with invalid photos
    And owner click lanjutkan button for next steps
    And owner invalid upload photo "depan kamar"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "dalam kamar"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner invalid upload photo "kamar mandi"
    Then verify warning upload gagal
    When owner valid upload photo kos
    And owner click lanjutkan button for next steps

  @TEST_LIMO-954 @createNewKos
  Scenario:[Add New Kost][Dashboard]Add new kost from Dashboard (status property kos diperiksa admin/reject && status apartment diperiksa admin/reject )
    And user check facilities under "Fasilitas Umum"
      | Air Jernih |
    And user check facilities under "Fasilitas Kamar"
      | Kasur |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas |
    And user check facilities under "Parkir"
      | Parkir Sapi |
    And owner click lanjutkan button for next steps
    And owner select size room "3 x 4"
    And owner input total room and room available as expected
      | total room | room available |
      | 15         | 10             |
    And owner click lanjutkan button for next steps
    And owner input the price room as expected
      | monthly price | check min rent duration | min rent duration | check other price | daily price | weekly price | three monthly price | six monthly price | yearly price |
      | 300000        | yes                     | Min. 1 Hari       | yes               | 50000       | 200000       | 800000              | 1700000           | 3000000      |
    And owner click lanjutkan button for next steps
    And owner click done in success page
    Then user see kos with valid name, status "Diperiksa Admin" and type "Kos Putri"

  @deleteKosFromAdmin
  Scenario: Delete kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner in admin kos owner page
    And admin delete kos