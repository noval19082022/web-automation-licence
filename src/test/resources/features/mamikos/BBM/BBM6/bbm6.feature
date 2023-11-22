@BBM6
Feature: BnB feature

  @OwnerBadgesNotLogin @OwnerBadges
  Scenario: Check Owner Badges on Kos Detail when not login tenant (BBM-500)
    Given user go to mamikos homepage
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithTenantLogin @OwnerBadges
  Scenario: Check Owner Badges on Kos Detail when login tenant (BBM-498)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0812345667788 | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @OwnerBadgesWithOwnerLogin @TEST_BBM-499
  Scenario: Check Owner Badges on Kos Detail when login owner (BBM-499)
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 089120220103  | 083176408442 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag                     | kost name prod       |
      | Kost andalusia spanyol eropa timur | kost payment desta 2 |
    Then user reached owner badges section

  @activatedDenda
  Scenario: Activated denda and input price, update denda, then delete denda
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089120220103 | 081328787342 | qwerty123 |
    And owner navigates to property saya kos
    And owner search kost "Kost Singgah Sini B Inter millan Tobelo Utara Halmahera Utara" on property saya page
    And user click Lihat Selengkapnya button for edit
    And owner click "Update Harga"
    And owner click toogle denda
    And owner input denda ammount:
      | Jumlah Denda | late pay |
      | 50000        | 7        |
    And owner click "Simpan"
    Then user cannot see "Rp50.000" on the list
    And owner click "Ubah"
    And owner input denda ammount:
      | Jumlah Denda | late pay |
      | 100000       | 5        |
    And owner click "Simpan"
    And owner click "Hapus"
    And owner click "Ya, Hapus"