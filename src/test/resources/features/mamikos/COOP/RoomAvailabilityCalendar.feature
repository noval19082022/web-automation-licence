@checkinKosBss
Feature: Room avability calender

@continue
  Scenario: BSS Waktu masuk kos booking is 1 days
    Given user go to mamikos homepage
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to owner dashboard
    And owner click "Ubah Peraturan Masuk Kos"
    And owner select kos "Kost Singgahsini Noval Tipe Episode"
    And owner click "Pilih nama kos"
    And owner click "Waktu mulai masuk kos"
    And owner click "Ubah waktu"
    And owner click on toggle entry time kos
    And owner edit Jarak waktu terdekat:
      | Jumlah  | Satuan Waktu |
      | 1       | Hari         |
    And owner logs out
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                      | kost name prod       |
      | Kost Singgahsini Noval Tipe Episode | kost payment desta 2 |
    And tenant dismiss FTUE booking benefit
    Then Tenant see booking date according to BSS setting
    And user logs out as a Tenant user

  Scenario: BSS Waktu masuk kos booking is 7 days
    And user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to owner dashboard
    And owner click "Ubah Peraturan Masuk Kos"
    And owner select kos "Kost Singgahsini Noval Tipe Episode"
    And owner click "Pilih nama kos"
    And owner click "Waktu mulai masuk kos"
    And owner click "Ubah waktu"
    And owner click on toggle entry time kos
    And owner edit Jarak waktu terdekat:
      | Jumlah  | Satuan Waktu |
      | 3       | Hari         |
    And owner logs out
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                      | kost name prod       |
      | Kost Singgahsini Noval Tipe Episode | kost payment desta 2 |
    Then Tenant see booking date according to BSS setting