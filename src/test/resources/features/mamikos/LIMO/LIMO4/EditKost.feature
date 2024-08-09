@regression @LIMO4 @editKost123456
Feature: Edit Kost

  @TEST_LIMO-938 @EditKosInvalidFacility @continue
  Scenario: [Web][Edit Kost] Edit kost fasilitas with invalid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408319 | 083176408319 | qwerty123 |
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
    And user uncheck facilities under "Parkir"
      | Parkir Mobil |
    Then user see edit finished button is disabled
    And user see "Fasilitas Umum" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user see "Fasilitas Kamar Mandi" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"

  @TEST_LIMO-963 @EditKos1to5NoChanges @continue
  Scenario: [Web][Edit Kost] Edit kost with condition user wants to edit step 1-5 without change anything
    When owner navigates to property saya kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click "Edit Data Lain"
    And user click button edit "Ketersediaan Kamar" kos
    And user click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    When user click done in success page pop up of edit kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
    Then user see kos with name "Kos oke bebek Vviop Depok Sleman", status "Aktif" and type "Kos Putra"

  @TEST_LIMO-890 @EditKosAddress @continue
  Scenario: [Web][Edit Kost] Edit kost address with valid data
    And owner navigates to property saya kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
    When user click Lihat Selengkapnya button for edit
    And user click "Edit Data Kos"
    And user click button edit "Alamat Kos" kos
    And user input kost location "Tobelo" and clicks on first autocomplete suggestion
    And user input address note "Perubahan agar diperiksa admin " and random text
    And user click button edit finished
    And user click done in success page pop up of edit kos
    And owner search kost "Kos oke bebek Vviop Depok Sleman" on property saya page
    Then user see kos with name "Kos oke bebek Vviop Depok Sleman", status "Diperiksa Admin" and type "Kos Putra"

  @TEST_LIMO-3436 @WEB @AUTOMATED
  Scenario: Verify Edited Kos In Admin Kos oke bebek Vviop Depok Sleman
    Given user try to logout from mamikos
    When admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Kos oke bebek Vviop Depok Sleman" in admin kos owner page
    And user verify the kos in admin kos owner

  ####### END OF ERA KOST BEBEKKKKKK

  @TEST_LIMO-850 @continue
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
    Examples:
      | kost name     |
      | MAMAHMUDALIMO |

  @TEST_LIMO-3435 @WEB @AUTOMATED
  Scenario: Verify Edited Kos In Admin MAMAHMUDALIMO
    Given user try to logout from mamikos
    When admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "MAMAHMUDALIMO" in admin kos owner page
    And user verify the kos in admin kos owner

  @TEST_LIMO-858 @updatefotokost
  Scenario: [Edit kos][Foto Kamar] Edit foto kamar with move or merge foto
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

  @TEST_LIMO-859 @updatefotokost
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


  Scenario: [Edit kos][Foto Kos]Edit kost with condition user with old kost && wants to edit foto && user already have photo booking active
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

  @TEST_LIMO-3434 @continue @editKost123 @WEB @AUTOMATED
  Scenario: [Edit kos][Edit data needs verification process] Status kos == active or reject && owner edit data needs verification process
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787881 |            | qwerty123 |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "PAPASUKA GENIT" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Data Kos" kos
    And owner fills valid data kos as expected
      | kos name       | room type check | room type name | kos type | description kos                     | build kos | other note     |
      | PAPASUKA GENIT | no              | -              | mix      | Kos tanpa bunga riba random ya guys | 2020      | Akan edit nama |
    And owner re-upload valid kos rule
    And owner click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    And owner click button edit data lain
    And user click button edit "Alamat Kos" kos
    And owner input address is "Tobelo"
    And owner input address note "depan rumah jokowi" and random text
    And owner click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    And owner click button edit data lain
    And user click button edit "Foto Kos" kos
    And owner remove photo for the order "1"
    And owner upload valid photo "bangunan tampak depan"
    And owner click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    And owner click button edit data lain
    And user click button edit "Foto Kamar" kos
    And owner remove photo for the order "1"
    And owner upload valid photo "depan kamar"
    And owner click button edit finished
    Then user see success add data kos pop up with text "Data Kos Telah Diperbarui"
    And user click done in success page pop up of edit kos
    Then user see kos with name "PAPASUKA GENIT", status "Diperiksa Admin" and type "Kos Campur"
#    Examples:
#      | kost nama      |
#      | PAPASUKA GENIT |

  @TEST_LIMO-2716 @editKost123
  Scenario: [Edit kos][Harga]Intercept confirmation on screen "Harga"
    Given user try to logout from mamikos
    When admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "PAPASUKA GENIT" in admin kos owner page
    And user verify the kos in admin kos owner

  @TEST_LIMO-3437 @WEB @AUTOMATED
  Scenario: Verify Kos In Admin After Intercept Confirmation On Screen "Harga"
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787881 |            | qwerty123 |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "PAPASUKA GENIT" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Ketersediaan Kamar" kos
    Then owner will see that the text "Atur Ketersediaan Kamar" is displayed
    And user click button edit "Harga" kos
    Then owner will see that the text "Update Harga Sewa" is displayed
    And owner tap on update harga if exist
    And user clicks update price button
    Then user see pop up success update price "Harga berhasil diupdate"

  @TEST_LIMO-861 @WEB @AUTOMATED @editKost
  Scenario: [Edit kos][Kos]Edit kost with condition user with old kost && Rejected Kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787884 |            | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "Desta Paris Test coba Banguntapan Bantul" on property saya page
    Then owner will see that the text "Data Kos Ditolak" is displayed
    And user clicks on edit data kos button
    Then owner will see that the text "Update kos anda" is displayed
    And user click button edit "Data Kos" kos
    And owner fills valid data kos as expected
      | kos name       | room type check | room type name | kos type | description kos                     | build kos | other note     |
      | PAPASUKA GENIT | no              | -              | mix      | Kos tanpa bunga riba random ya guys | 2020      | Akan edit nama |
    And owner re-upload valid kos rule
    And user click button edit "Ketersediaan Kamar" kos
    Then owner will see that the text "Mohon Perhatiannya Sebentar" is displayed
    * owner will see that the text "Jika pindah ke halaman lain, maka data yang diisi di langkah ini tidak akan tersimpan." is displayed

  @TEST_LIMO-846 @WEB @AUTOMATED @continue
  Scenario: [Edit kos][Kos]Edit kost with condition user with old kost && Data Tahun Kos Dibangun OR Deskripsi Kos OR Fasilitas Kamar Mandi OR Fasilitas Umum tidak ada
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787884 |            | Perempuan |
    And owner dismiss FTUE goldplus
    And owner navigates to property saya kos
    And owner search kost "automation limo LIMO 2727 Depok Sleman" on property saya page
    And user click Lihat Selengkapnya button for edit
    And user clicks on edit data kos button
    And user click button edit "Data Kos" kos
    Then owner will see that the text "Apa nama kos ini?" is displayed
    And owner fills valid data kos as expected
      | kos name    | room type check | room type name | kos type | description kos               | build kos | other note     |
      | <kost name> | no              | -              | mix      | Kos automation random ya guys | 1999      | Akan edit nama |
    And user click button edit "Ketersediaan Kamar" kos
    Then owner will see that the text "Mohon Perhatiannya Sebentar" is displayed
    * owner will see that the text "Jika pindah ke halaman lain, maka data yang diisi di langkah ini tidak akan tersimpan." is displayed

  @TEST_LIMO-855 @WEB @AUTOMATED
  Scenario: [Edit kos][Kos]Edit kost with condition user with old kost && Foto Kos OR Foto Kamar belum di mapping ke yg baru (dari data lama) OR Provinsi field kosong
#    When user click on "close" button
    When owner close pop up in edit kost
    And owner clear description kost on edit page
    Then owner will see that the text "Anda belum mengisi deskripsi kos." is displayed
    And owner fills valid data kos as expected
      | kos name    | room type check | room type name | kos type | description kos | build kos | other note     |
      | <kost name> | no              | -              | mix      | okokokok        | 1999      | Akan edit nama |
    And user click button edit "Alamat Kos" kos
    Then owner will see that the text "Mohon Perhatiannya Sebentar" is displayed
    * owner will see that the text "Jika pindah ke halaman lain, maka data yang diisi di langkah ini tidak akan tersimpan." is displayed