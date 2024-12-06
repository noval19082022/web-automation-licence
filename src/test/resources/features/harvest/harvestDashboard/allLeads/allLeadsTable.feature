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