@regression @pman3 @harvest

Feature: All Leads Table

  @TEST_SS-898
  Scenario: Check Column in All Leads Table
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    Then admin should redirect to Harvest Dashboard
    And all leads table contains column
      | Lead ID               |
      | Nomor HP Pemilik      |
      | Nama Pemilik          |
      | Nama Properti         |
      | Lead Source           |
      | Source Name           |
      | Total Room            |
      | Foto Properti         |
      | Kota                  |
      | Kecamatan             |
      | Kelurahan             |
      | Lat-Long              |
      | Alamat                |
      | Property ID           |
      | Property Status       |
      | Leads Status          |
      | Leadbase ID           |
      | Area Priority         |
      | Segmentasi            |
      | Kategori              |
      | Tipe Properti         |
      | Gender Kos            |
      | Jumlah Kamar Terisi   |
      | Occupancy Rate        |
      | Jumlah Properti       |
      | Jumlah Listing        |
      | Harga Kos (per-bulan) |
      | Created By            |
      | Created Date          |
      | Modified Date         |
      | Modified By           |
      | isJunk                |

  @TEST_SS-7489
  Scenario: [Web][Harverst][Search]Admin search by Nomor HP Pemilik
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin search by "No HP Pemilik" with "087655762276"
    Then admin validate data in table with "087655762276"

  @TEST_SS-7490
  Scenario: [Web][Harverst][Search]Admin search by Leads ID
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin search by "Lead ID" with "AO35517"
    Then admin validate data in table with "AO35517"

  @TEST_SS-7491
  Scenario: [Web][Harverst][Search]Admin search Nama Kos
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin search by "Nama Kos" with "Kost Zahroni"
    Then admin validate data in table with "Kost Zahroni"

  @TEST_SS-7492
  Scenario: [Web][Harverst][Search]Admin search by Nama Pemilik
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin search by "Nama Pemilik" with "Imam Zahroni"
    Then admin validate data in table with "Imam Zahroni"

  @TEST_SS-7493
  Scenario: [Web][Harverst][Filter]Admin filter by Kota
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin clicks Filter in Harvest Dashboard
    And admin selects "Kota" and "Kota Jakarta Barat" from dropdown
    And admin click on terapkan button
    Then admin validate kota name with "Kota Jakarta Barat"

  @TEST_SS-7494
  Scenario: [Web][Harverst][Filter]Admin filter by Kecamatan
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin clicks Filter in Harvest Dashboard
    And admin selects "Kota" and "Kota Jakarta Barat" from dropdown
    And admin selects "Kecamatan" and "Palmerah" from dropdown
    And admin click on terapkan button
    Then admin validate kota name with "Palmerah"

  @TEST_SS-7495
  Scenario: [Web][Harverst][Filter]Admin filter by Kelurahan
    Given admin navigates to Harvest Dashboard Login
    When admin login Harvest Dashboard:
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    And admin should redirect to Harvest Dashboard
    And admin clicks Filter in Harvest Dashboard
    And admin selects "Kota" and "Kota Jakarta Barat" from dropdown
    And admin selects "Kecamatan" and "Palmerah" from dropdown
    And admin selects "Kelurahan" and "Kemanggisan" from dropdown
    And admin click on terapkan button
    Then admin validate kota name with "Kemanggisan"