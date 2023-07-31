@BBM4 @owner @tenant
Feature: Owner Tenant List

  @TEST_BBM-2
  Scenario: Check Detail Penyewa and detail contract when tenant already checkin
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag       | phone prod     | password        |
      | 08900000000022   | 08900000000022 | mamikosqa123    |
    And owner go to Penyewa page of kost "Kost Adi Auto SinggahSini"
    Then user can see "Adi Teng Voucher Suggestion" as tenant name, "0890867321217" as phone number, "Sedang menyewa" status, and photo
    When user can see detail tenant ("Adi Teng Voucher Suggestion", "Laki-laki", "Kawin", "Karyawan")
    Then user cannot see checkin tenant disclaimer alert
    When user click on kontrak sewa button
    Then user can see detail contract ("27 Juni 2023", "27 Juni 2025", "10.000.000", "2 tahun", "27 Juni 2024")
    When system display change contract rent button
    Then system display terminate contract link
    And user navigate to penyewa page
    And user search kost "Kost Adi Auto SinggahSini"
    And user click Selengkapnya button on "Dhiandra At Detail" contract
    Then user can see disclaimer "Penyewa dijadwalkan check-in kos pada 1 Maret 2023. Uang sewa akan ditransfer ke rekening Anda dalam 1x24 jam setelah penyewa klik “Check-in” via Mamikos."