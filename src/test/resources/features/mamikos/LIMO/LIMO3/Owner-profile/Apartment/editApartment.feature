@regression @LIMO-3 @listing-monetization @editApartement

Feature: Owner - Edit Apartment

  Scenario: Edit Apartment without edit data and then submit data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083132824758 | qwerty123 |
    And owner navigates to property saya apartemen
    And owner search apart "Automation testing" on property saya page
    And owner click edit data apartemen
    And owner submit edit data apartemen
    Then verify status apartemen "Diperiksa Admin"

  @verifikasiProperti
  Scenario: Admin verified data apartemen
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Automation testing" in admin kos owner page
    And admin verify the property "Automation testing"
    Then verify "Success! Room has been successfully updated" displayed

  @editApartWithChanges
  Scenario: Edit Apartment with edit valid data
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 083176408311 | 083132824758 | qwerty123 |
    And owner navigates to property saya apartemen
    And owner search apart "Automation testing" on property saya page
    And owner click edit data apartemen
    And owner input requirement field add apartemen is as expected
      | nama project | nama unit          | nomor unit | tipe unit | lantai | luas unit | deskripsi                        |
      | null         | Automation testing | AT 2023    | 2 BR      | 10     | 75        | ini apartemen testing automation |
    And owner submit edit data apartemen
    Then verify status apartemen "Diperiksa Admin"

  @verifikasiProperti
  Scenario: Admin verified data apartemen
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin bangkrupux navigate to kost owner menu
    And admin bangkrupux search kost owner "Automation testing" in admin kos owner page
    And admin verify the property "Automation testing"
    Then verify "Success! Room has been successfully updated" displayed