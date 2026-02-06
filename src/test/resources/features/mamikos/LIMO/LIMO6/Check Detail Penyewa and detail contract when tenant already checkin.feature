@LIMO6
Feature: Check Detail Penyewa and detail contract when tenant already checkin

  @TEST_SS-4273
  Scenario: Check Detail Penyewa and detail contract when tenant already checkin
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod     | password     |
      | 08900000000022 | 08900000000022 | mamikosqa123 |
    And owner go to Penyewa page of kost "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user click Selengkapnya button on "Adi Teng Blacklist Mamipoin" contract
    Then user can see "Adi Teng Blacklist Mamipoin" as tenant name, "0890867321216" as phone number, "Sedang menyewa" status, and photo
    When user can see detail tenant ("Adi Teng Blacklist Mamipoin", "Laki-laki", "Kawin", "kerja")
    Then user cannot see checkin tenant disclaimer alert
    When user click on kontrak sewa button
    Then user can see detail contract ("14 Juni 2022", "14 Juni 2034", "10.000.000", "12 tahun", "14 Juni 2033")
    When system display change contract rent button
    Then system display terminate contract link
    And user navigate to penyewa page
    And user search kost "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user click Selengkapnya button on "Dhiandra At Mamipoin" contract
    Then user can see disclaimer "Penyewa dijadwalkan check-in kos pada 5 April 2026. Uang sewa akan ditransfer ke rekening Anda dalam 1x24 jam setelah penyewa klik “Check-in” via Mamikos."