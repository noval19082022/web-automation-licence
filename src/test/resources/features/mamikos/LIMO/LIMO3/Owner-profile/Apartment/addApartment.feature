@regression @LIMO-3 @listing-monetization @addApartement

Feature: Owner - Add Apartment

  @addapart
  Scenario: Owner - Add apartment with valid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083132824758 | qwerty123 |
    And owner navigates to property saya apartemen
    And owner click tambah data iklan "Apartemen"
    And owner input requirement field add apartemen is as expected
      | nama project                   | nama unit       | nomor unit           | tipe unit     | lantai | luas unit | deskripsi |
      | Apartemen Testing Parangtritis | test automation | test automation 2023 | 1-Room Studio | 1      | 100       | null      |
    And owner input harga sewa "Perbulan" is "50000000"
    And owner select fasilitas unit "WiFi" and fasilitas kamar "Furnished"
    And owner upload cover photo apartemen
    And owner upload photo "kamar" of apartemen
    And owner upload photo "kamar mandi" of apartemen
    And owner upload photo "lainnya" of apartemen
    And owner click "Batal" button
    Then owner can see url link is for property saya apartemen