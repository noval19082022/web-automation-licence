@regression @LIMO4
Feature: Edit Kost

  @TEST_LIMO-2877 @EditKosInvalidFacility @continue
  Scenario: [Web][Edit Kost] Edit kost fasilitas with invalid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password    |
      | 083176408311   | 083176408311   | qwerty123   |
    And owner click "Nanti Saja"
    And owner navigates to property saya kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit "Fasilitas" kos
    And user uncheck facilities under "Fasilitas Umum"
      | CCTV |
    And user uncheck facilities under "Fasilitas Kamar"
      | Kasur     |
      | Sofa      |
    And user uncheck facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Bak mandi |
      | Bathup    |
      | Gayung    |
    And user uncheck facilities under "Parkir"
      | Parkir Mobil |
    Then user see edit finished button is disabled
    And user see "Fasilitas Umum" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar Mandi" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"

  @TEST_LIMO-2879 @EditKos1to5NoChanges @continue
  Scenario: [Web][Edit Kost] Edit kost with condition user wants to edit step 1-5 without change anything
    When owner navigates to property saya kos
    And owner search kost "Kos oke bebek Tipe o" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click "Edit Data Lain"
    And user click button edit "Ketersediaan Kamar" kos
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click done in success page pop up of edit kos
    And owner search kost "Kos oke bebek Tipe o" on property saya page
    Then user see kos with name "Kos oke bebek Tipe o", status "Aktif" and type "Kos Campur"

