@regression @pman3 @harvest

  Feature: All Leads Table

    @TEST_SS-898
    Scenario: Check Column in All Leads Table
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
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
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin search by "No HP Pemilik" with "087655762276"
      Then admin validate data in table with "087655762276"

    @TEST_SS-7490
    Scenario: [Web][Harverst][Search]Admin search by Leads ID
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin search by "Lead ID" with "AO35517"
      Then admin validate data in table with "AO35517"

    @TEST_SS-7491
    Scenario: [Web][Harverst][Search]Admin search Nama Kos
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin search by "Nama Kos" with "Kost Zahroni"
      Then admin validate data in table with "Kost Zahroni"

    @TEST_SS-7492
      Scenario: [Web][Harverst][Search]Admin search by Nama Pemilik
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin search by "Nama Pemilik" with "Imam Zahroni"
      Then admin validate data in table with "Imam Zahroni"

    @TEST_SS-7493
    Scenario: [Web][Harverst][Filter]Admin filter by Kota
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin clicks Filter in Harvest Dashboard
      And admin selects "Kota" and "Kota Jakarta Barat" from dropdown
      And admin click on terapkan button
      Then admin validate kota name with "Kota Jakarta Barat"

    @TEST_SS-7494
    Scenario: [Web][Harverst][Filter]Admin filter by Kecamatan
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
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
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      And admin should redirect to Harvest Dashboard
      And admin clicks Filter in Harvest Dashboard
      And admin selects "Kota" and "Kota Jakarta Barat" from dropdown
      And admin selects "Kecamatan" and "Palmerah" from dropdown
      And admin selects "Kelurahan" and "Kemanggisan" from dropdown
      And admin click on terapkan button
      Then admin validate kota name with "Kemanggisan"

    @TEST_SS-8910 @continue
    Scenario: Admin filter Uncurated Leads Curation Status
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email                         | password  |
        | automationpman01@mamikos.com  | qwerty123 |
      Then admin should redirect to Harvest Dashboard
      When admin filter Leads Curation "Uncurated"
      Then system only show "uncurated" leads

    @TEST_SS-8911 @continue
    Scenario: Admin filter Submitted to Kissflow Leads Curation Status
      When admin filter Leads Curation "Submitted to Kissflow"
      Then system only show "Submitted to Kissflow" leads

    @TEST_SS-8912
    Scenario: Admin filter Not Eligible to P1 Leads Curation Status
      When admin filter Leads Curation "Not Eligible to P1"
      Then system only show "Not Eligible to P1" leads

    @TEST_SS-954
    Scenario: Admin mark leads as Submitted to Kissflow
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email              | password       |
        | pman@mamiteam.com  | pmanM4m1t34m!! |
      Then admin should redirect to Harvest Dashboard as admin
      When admin filter ILB only
      And admin filter Leads Curation "Uncurated"
      And admin mark leads submit to kissflow as "Yes"
      Then leads should be have label in Leads Status "Submitted to Kissflow"

    @TEST_SS-946
    Scenario: Admin mark leads as Not Eligible to P1
      Given admin navigates to Harvest Dashboard Login
      When admin login Harvest Dashboard:
        | email              | password       |
        | pman@mamiteam.com  | pmanM4m1t34m!! |
      Then admin should redirect to Harvest Dashboard as admin
      When admin filter ILB only
      And admin filter Leads Curation "Uncurated"
      And admin mark leads submit to kissflow as "No"
      Then leads should be have label in Leads Status "Not Eligible to P1"