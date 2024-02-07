@BBM5
Feature: Check Update TnC Booking on Pengajuan sewa page

  @continue @TEST_COOP-1242 @TEST_COOP-1247
  Scenario: [TnC Booking][Detail Booking] Check TnC Booking on Pengajuan sewa page for kost reguler (BBM-1194)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password     |
      | 0890000000313 | 0890000000313 | Bismillah@01 |
    And tenant search kost then go to kost details:
      | kost name stag                          | kost name prod                          |
      | Kost Jawa Tobelo Utara Halmahera Utara  | kost Jawa Tobelo Utara Halmahera Utara  |
    And user want to dismiss FTUE
    And tenant fill booking data for "today" and "Per Bulan"
    And tenant click ajukan sewa button on kost detail page
    Then user will open new tab and go to Booking form
    And tenant click ajukan sewa button on pengajuan sewa page
    Then tenant can see TnC with "Syarat Ketentuan Umum"
    When tenant click on TnC with "Syarat Ketentuan Umum"
    Then tenant can see TnC content with "Syarat dan Ketentuan Umum"

  @TEST_COOP-1246
  Scenario: [Pengajuan Sewa][TnC Booking]Check TnC booking for kost Singgah sini, APIK and Kos Pilihan
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag            | kost name prod       |
      | Kost Cibinong Bogor COOP Kece | kost cibinong bogor  |
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
