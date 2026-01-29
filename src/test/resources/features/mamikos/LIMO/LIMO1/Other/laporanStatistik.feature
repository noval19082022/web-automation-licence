@listing-monetization @regression @LIMO1
Feature: Laporan Statistik

  @TEST_LIMO-4055
  Scenario: [WEB][Statistic Page] Owner only have 2 active kost and auto select kost listing that are in the top order
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202303 | 0          | qwerty123 |
    And owner navigates to statistic page
    Then auto select kost listing that are in the top order
      | KosName                                |
      | Kost SkinCare Tobelo TIPE A Tobelo Utara Halmahera Utara |

  @TEST_LIMO-277
  Scenario: [Form add New Kost][Kos]Create new room type from "Tipe A" && edit data kos && mamipay not active
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password  |
      | 0891202303 | qwerty123 |
    And owner navigates to property saya kos
    When owner close pop up BBK at kos list page
    And owner click tambah data iklan "Kost"
    And user click add new kos button
    And owner fills valid data kos as expected
      | kos name             | room type check | room type name        | kos type | description kos       | build kos | other note |
      | kost Automation TEST | yes             | Tipe New BBK Rejected | mix      | kos terbaik hari raya | 2023      |            |
    And owner set rules kos:
      | Akses 24 Jam |
      | Security     |
    And owner upload valid rule kos
    And owner click Lanjutkan for input kos address
    And owner input address is "Tobelo"
    And owner click lanjutkan button for next steps
    And user clicks on the close button
    And owner upload valid photo "bangunan tampak depan"
    And owner upload valid photo "tampilan dalam bangunan"
    And owner upload valid photo "tampak dari jalan"
    And owner click lanjutkan button for next steps
    And owner upload valid photo "depan kamar"
    And owner upload valid photo "dalam kamar"
    And owner upload valid photo "kamar mandi"
    And owner upload valid photo "lain"
    And owner click lanjutkan button for next steps
    And user check facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user uncheck facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user see "Fasilitas Umum" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user check facilities under "Fasilitas Umum"
      | Air Jernih |
      | Kompor     |
    And user check facilities under "Fasilitas Kamar"
      | Kasur |
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
    And user uncheck facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
    And user see "Fasilitas Kamar Mandi" has warning title "Pilih Fasilitas" and description "Pilih minimal 1 fasilitas"
    And user check facilities under "Fasilitas Kamar Mandi"
      | Air panas |
      | Shower    |
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
    Then owner will see that the text "Data Kos Dikirimkan" is displayed

  Scenario: Accept kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner "0891202303" in admin kos owner page
    And admin accept kos
    Then verify "Success! Room has been successfully updated" displayed

  Scenario: [WEB][Statistic Page] Statistic section when owner have 1 propety just activated by today
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202303 | 0          | qwerty123 |
    And owner navigates to statistic page
   # Then owner can see display empty state "Properti Belum Memiliki Performa"

  Scenario: Delete kos from admin
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search phone owner "0891202303" in admin kos owner page
    And admin delete kos
    Then verify "Success! Room has been succesfully deleted" displayed

  @TEST_LIMO-276
  Scenario: [WEB][Statistic Page][Filter 7 days] Check when owner have property active less than 7 days, but more than 1 day
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner navigates to statistic page
    And user click on "Kos XDR Rajeg Tangerang Rajeg Tangerang" button
    And owner click on filter "7 Hari" at statistic report
    And owner can see total sewa
    And owner can see total chat
    And owner can see total click
    And owner can see periode Performa
    Then owner can see growth graphic

  @TEST_LIMO-268
  Scenario: [WEB][Statistic Page][Filter 30 days] Check when owner have property active more than 30 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner navigates to statistic page
    And user click on "Kos XDR Rajeg Tangerang Rajeg Tangerang" button
    And owner click on filter "30 Hari" at statistic report
    And owner can see total sewa
    And owner can see total chat
    And owner can see total click
    And owner can see periode Performa
    And owner will see that the text "* Kenaikan/penurunan dibandingkan dengan periode sebelumnya." is displayed
    Then owner can see growth graphic

  @TEST_LIMO-266
  Scenario: [WEB][Statistic Page][Filter 30 days] Check when owner have property active more than 30 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner navigates to statistic page
    And user click on "Kos XDR Rajeg Tangerang Rajeg Tangerang" button
    And owner click on filter "30 Hari" at statistic report
    And owner click on tooltip at performa section
    Then owner will see that the text "Keterangan Performa" is displayed

