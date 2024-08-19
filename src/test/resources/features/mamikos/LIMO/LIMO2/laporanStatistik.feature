@listing-monetization @regression @LIMO2
Feature: Laporan Statistik

  @LIMO-4055
  Scenario: [WEB][Statistic Page] Owner only have 2 active kost and auto select kost listing that are in the top order
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202303 | 0          | qwerty123 |
    And owner accsess statistic page
    Then auto select kost listing that are in the top order
      | KosName         |
      | Kost Bandicoot Tobelo Tobelo Halmahera |

  @LIMO-277
  Scenario: [WEB][Statistic Page] Statistic section when owner have 1 propety just activated by today
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202412 | 0          | qwerty123 |
    And owner accsess statistic page
    Then owner can see display empty state "Properti Belum Memiliki Performa"

  @LIMO-276
  Scenario: [WEB][Statistic Page][Filter 7 days] Check when owner have property active less than 7 days, but more than 1 day
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner accsess statistic page
    And user click on "Kos QuQu 77 ex jati 2" button
    And owner click on filter "7 Hari" at statistic report
    And owner can see total sewa
    And owner can see total chat
    And owner can see total click
    And owner can see periode Performa
    Then owner cannot see growth graphic

  @LIMO-268
  Scenario: [WEB][Statistic Page][Filter 30 days] Check when owner have property active more than 30 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner accsess statistic page
    And user click on "Kos QuQu 77 ex jati 2" button
    And owner click on filter "30 Hari" at statistic report
    And owner can see total sewa
    And owner can see total chat
    And owner can see total click
    And owner can see periode Performa
    And owner will see that the text "* Kenaikan/penurunan dibandingkan dengan periode sebelumnya." is displayed
    Then owner can see growth graphic

  @LIMO-266
  Scenario: [WEB][Statistic Page][Filter 30 days] Check when owner have property active more than 30 days
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password  |
      | 0891202406 | 0          | qwerty123 |
    And owner accsess statistic page
    And user click on "Kos QuQu 77 ex jati 2" button
    And owner click on filter "30 Hari" at statistic report
    And owner click on tooltip at performa section
    Then owner will see that the text "Keterangan Performa" is displayed

