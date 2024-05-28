@regression @LIMO4 @editKost
Feature: Edit Kost

  @TEST_LIMO-2877 @EditKosInvalidFacility @continue
  Scenario: [Web][Edit Kost] Edit kost fasilitas with invalid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083176408311 | qwerty123 |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
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
    And owner search kost "Kos oke bebek Tipe Mamitest Not Change" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click "Edit Data Lain"
    And user click button edit "Ketersediaan Kamar" kos
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click done in success page pop up of edit kos
    And owner search kost "Kos oke bebek Tipe Mamitest Not Change" on property saya page
    Then user see kos with name "Kos oke bebek Tipe Mamitest Not Change", status "Aktif" and type "Kos Campur"
#
  @TEST_LIMO-2878 @EditKosAddress
  Scenario: [Web][Edit Kost] Edit kost address with valid data
    When user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit "Alamat Kos" kos
    And user input kost location "Tobelo" and clicks on first autocomplete suggestion
    And user input address note "Perubahan agar diperiksa admin " and random text
    And user click button edit finished
    And user click done in success page pop up of edit kos
    And owner search kost "Kos oke bebek Tipe Mamitest Not Change" on property saya page
    Then user see kos with name "Kos oke bebek Tipe Mamitest Not Change", status "Diperiksa Admin" and type "Kos Campur"

  Scenario: Verify kos in admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Kos oke bebek Tipe Mamitest Not Change" in admin kos owner page
    And user verify the kos in admin kos owner

  @TEST_LIMO-2719
  Scenario Outline: Status kos is active or reject and owner edit description kos
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "<kost name>" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Data Kos" kos
    And owner fills valid data kos as expected
      | kos name    | room type check | room type name | kos type | description kos                     | build kos | other note     |
      | <kost name> | no              | -              | mix      | Kos tanpa bunga riba random ya guys | 2020      | Akan edit nama |
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    And user click done in success page pop up of edit kos
    Then user see kos with name "<kost name>", status "Diperiksa Admin" and type "Kos Campur"
    And user logs out
#  Scenario: Verify kos in admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "<kost name>" in admin kos owner page
    And user verify the kos in admin kos owner
    Examples:
      | kost name     |
      | MAMAHMUDALIMO |

  @TEST_LIMO-2710 @updatefotokost
  Scenario: [Edit kos][Foto Kamar]Edit foto kamar with move or merge foto
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "MAMAHMUDALIMO" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Foto Kamar" kos
    And user clicks button move photo on "Foto dalam kamar"
    And user select destination move photo room on "Foto depan kamar"
    Then user will see that the text "Anda harus melengkapi foto ini" is displayed

  @TEST_LIMO-2709 @updatefotokost
  Scenario: [Edit kos][Foto Kos]Edit foto kos with move or merge foto
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 081328787342 | 081328787342 | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "MAMAHMUDALIMO" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Foto Kos" kos
    And user clicks button move photo on "Foto bangunan tampak depan"
    And user select destination move photo room on "Foto tampilan dalam bangunan"
    Then user will see that the text "Anda harus melengkapi foto ini" is displayed

  @TEST_LIMO-2713
  Scenario: [Edit kos][Foto Kos]Edit foto kos with move or merge foto
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password    |
      | 081292039331 | 085714531241 | digantilagi |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "Kost cece 4 edit" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Foto Kos" kos
    Then user will see that the text "Maaf, Foto Tidak Bisa Diedit" is displayed
    And user will see that the text "Saat ini Anda sedang mengikuti Mamikos Pro-Photo. Untuk bisa mengedit foto, silakan hubungi CS Admin" is displayed