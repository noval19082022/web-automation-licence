@regression @LIMO4 @editKost
Feature: Edit Kost

  @precondition
  Scenario: Verify Edited Kos In Admin Kos oke bebek Vvv Depok Sleman
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Kost Selling Cross D DD Serang Serang" with phone number "0891202106" in admin kos owner page
    And user verify the kos in admin kos owner if exist

  @TEST_LIMO-938 @EditKosInvalidFacility @continue
  Scenario: [Web][Edit Kost] Edit kost fasilitas with invalid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 0891202106   | 083176408319 | qwerty123 |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "Kost Selling Cross D DD Serang Serang" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Fasilitas" kos
    And user uncheck facilities under "Fasilitas Umum"
      | CCTV |
    And user uncheck facilities under "Fasilitas Kamar"
      | Kasur |
      | Sofa  |
    And user uncheck facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Bak mandi |
    And user uncheck facilities under "Parkir"
      | Parkir Mobil |
    Then user see edit finished button is disabled
    And user see "Fasilitas Umum" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar Mandi" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"

  @TEST_LIMO-963 @EditKos1to5NoChanges @continue
  Scenario: [Web][Edit Kost] Edit kost with condition user wants to edit step 1-5 without change anything
    When owner navigates to property saya kos
    And owner search kost "Kost Selling Cross D DD Serang Serang" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner clicks on Edit Data Kos button number "1"
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click "Edit Data Lain"
    And user click button edit "Ketersediaan Kamar" kos
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click done in success page pop up of edit kos
    And owner search kost "Kost Selling Cross D DD Serang Serang" on property saya page
    Then user see kos with name "Kost Selling Cross D DD Serang Serang", status "Aktif" and type "Kos Campur"

  @TEST_LIMO-890 @EditKosAddress @continue
  Scenario: [Web][Edit Kost] Edit kost address with valid data
    And owner navigates to property saya kos
    And owner search kost "Kost Selling Cross D DD Serang Serang" on property saya page
    When user click Lihat Selengkapnya button for edit
    And owner clicks on Edit Data Kos button number "1"
    And user click button edit "Alamat Kos" kos
    And user input kost location "Tobelo utara" and clicks on first autocomplete suggestion
    And user input address note "Perubahan agar diperiksa admin " and random text
    And user click button edit finished
    And user click done in success page pop up of edit kos
    And owner search kost "Kost Selling Cross D DD Serang Serang" on property saya page
    Then user see kos with name "Kost Selling Cross D DD Serang Serang", status "Aktif" and type "Kos Campur"

  @TEST_LIMO-3436 @WEB @AUTOMATED
  Scenario: Verify Edited Kos In Admin Kos oke bebek Vvv Depok Sleman
    Given user try to logout from mamikos
    When admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Kost Selling Cross D DD Serang Serang" with phone number "0891202106" in admin kos owner page
    And user verify the kos in admin kos owner if exist