@BBM5
Feature: [TnC Booking][Detail Booking] Check Update TnC Booking on Pengajuan sewa page

  @continue @TEST_BBM-1194 @TEST_BBM-1583
  Scenario: [TnC Booking][Detail Booking] Check TnC Booking on Pengajuan sewa page for kost reguler (BBM-1194)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890000000313 | 0890000000313 | Bismillah@01 |
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod                          |
      | kost jawa Tobelo Utara Halmahera Utara  | kost jawa Tobelo Utara Halmahera Utara  |
    And user want to dismiss FTUE
    And tenant fill booking data for "today" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user will open new tab and go to Booking form
    And tenant click ajukan sewa button on pengajuan sewa page
    Then tenant can see TnC with "Syarat Ketentuan Umum"
    When tenant click on TnC with "Syarat Ketentuan Umum"
    Then tenant can see TnC content with "Syarat dan Ketentuan Umum"

  @TEST_BBM-1582
  Scenario: [Pengajuan Sewa][TnC Booking]Check TnC booking for kost Singgah sini, APIK and Kos Pilihan
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag       | kost name prod       |
      | kost cibinong bogor  | kost cibinong bogor  |
    And tenant fill booking data for "today" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user will open new tab and go to Booking form
    And tenant click ajukan sewa button on pengajuan sewa page
    Then tenant can see TnC with "Syarat dan Ketentuan Umum"
    When tenant click on TnC with "Syarat dan Ketentuan Umum"
    Then tenant can see TnC content with "Syarat dan Ketentuan Umum"
    When tenant can see TnC with "Syarat dan Ketentuan Tinggal di Singgahsini, Apik, & Kos Pilihan"
    And tenant click on TnC with "Syarat dan Ketentuan Tinggal di Singgahsini, Apik, & Kos Pilihan"
    Then tenant can see TnC content with "Syarat dan Ketentuan Tinggal di Singgahsini dan APIK"
