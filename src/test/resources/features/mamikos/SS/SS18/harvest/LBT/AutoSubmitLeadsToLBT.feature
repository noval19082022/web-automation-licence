@regression @SS16 @harvest @lbt

  Feature: Auto submit leads in Area Prio

    @TEST_SS-10883
    Scenario: NLB in Area Prio auto submitted to LBT
      Given user navigates to NLB registration page
      And user fill and submit NLB registration form
        | Nama Pemilik Kos    | Total Kamar Dikelola | Total Kamar Terisi | Kota             | Kecamatan | Kelurahan  | Tipe Kamar | Harga Sewa | Renovasi          | Item Renovasi       | Penjelasan Renovasi | Pemilik Mamikos |
        | Auto NLB Area Prio  | 10                   | 5                  | Kabupaten Bantul | Kasihan   | Tamantirto | Tidak      | 1500000    | Renovasi Bangunan | Perbaikan Bangunan  | Renovasi kos test   | Tidak           |
      Then system show NLB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved NLB phone number
      Then leads with saved NLB phone number found in LBT
      And leads status is "Submitted to LBT"

    @TEST_SS-10884
    Scenario: NLB not in Area Prio not submitted to LBT
      Given user navigates to NLB registration page
      And user fill and submit NLB registration form
        | Nama Pemilik Kos    | Total Kamar Dikelola | Total Kamar Terisi | Kota              | Kecamatan | Kelurahan | Tipe Kamar | Harga Sewa | Renovasi          | Item Renovasi       | Penjelasan Renovasi | Pemilik Mamikos |
        | Auto NLB Non Prio   | 10                   | 5                  | Kabupaten Klaten  | Jatinom   | Mranggen  | Tidak      | 1500000    | Renovasi Bangunan | Perbaikan Bangunan  | Renovasi kos test   | Tidak           |
      Then system show NLB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved NLB phone number
      Then leads with saved NLB phone number not found in LBT

    @TEST_SS-10885
    Scenario: ILB in Area Prio auto submitted to LBT
      Given user navigates to ILB registration page
      And user fill and submit ILB registration form
        | Nama Lengkap       | Nama Kos          | Total Kamar | Kota             | Kecamatan | Kelurahan  | Alamat              |
        | Auto ILB Area Prio | Kos Auto ILB Prio | 10          | Kabupaten Bantul | Kasihan   | Tamantirto | Jl. Test Alamat 123 |
      Then system show ILB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads with saved ILB phone number found in LBT
      And ILB leads status is "Submitted to LBT"

    @TEST_SS-10886
    Scenario: ILB not in Area Prio not submitted to LBT
      Given user navigates to ILB registration page
      And user fill and submit ILB registration form
        | Nama Lengkap        | Nama Kos            | Total Kamar | Kota             | Kecamatan | Kelurahan | Alamat              |
        | Auto ILB Non Prio   | Kos Auto ILB Non    | 10          | Kabupaten Klaten | Jatinom   | Mranggen  | Jl. Test Alamat 456 |
      Then system show ILB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved ILB phone number
      Then leads with saved ILB phone number not found in LBT
