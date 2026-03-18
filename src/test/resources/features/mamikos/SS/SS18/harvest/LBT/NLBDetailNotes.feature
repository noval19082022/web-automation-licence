@regression @SS16 @harvest @lbt @NLBNotes

  Feature: Notes for NLB detail renovation

    @TEST_SS-11307
    Scenario: NLB Renovation leads should have detail renovation in Notes
      Given user navigates to NLB registration page
      And user fill and submit NLB registration form
        | Nama Pemilik Kos    | Total Kamar Dikelola | Total Kamar Terisi | Kota             | Kecamatan | Kelurahan  | Tipe Kamar | Harga Sewa | Renovasi          | Item Renovasi                        | Penjelasan Renovasi     | Pemilik Mamikos |
        | Auto NLB Reno Notes | 10                   | 5                  | Kabupaten Bantul | Kasihan   | Tamantirto | Tidak      | 1500000    | Renovasi Bangunan | Perbaikan Bangunan, Penambahan Kamar | Renovasi kos untuk test | Tidak           |
      Then system show NLB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved NLB phone number
      Then leads with saved NLB phone number found in LBT
      When admin clicks on leads with saved NLB phone number
      And admin clicks on tab "Data Pemilik & Properti"
      Then Notes should contain "building"
      And Notes should contain "building_reparation"
      And Notes should contain "new_room"
      And Notes should contain "Renovasi kos untuk test"

    @TEST_SS-11631
    Scenario: NLB Facility leads should have detail renovation in Notes
      Given user navigates to NLB registration page
      And user fill and submit NLB registration form
        | Nama Pemilik Kos    | Total Kamar Dikelola | Total Kamar Terisi | Kota             | Kecamatan | Kelurahan  | Tipe Kamar | Harga Sewa | Renovasi             | Item Renovasi                                         | Penjelasan Renovasi       | Pemilik Mamikos |
        | Auto NLB Fasi Notes | 10                   | 5                  | Kabupaten Bantul | Kasihan   | Tamantirto | Tidak      | 1500000    | Penambahan Fasilitas | Penambahan Fasilitas Kamar, Penambahan Fasilitas Umum | Penambahan fasilitas test | Tidak           |
      Then system show NLB registration success message
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password       |
        | pman@mamiteam.com | pmanM4m1t34m!! |
      And admin click sidebar menu "Lead Base Tracker"
      And admin search leads by "Nomor HP Pemilik" with saved NLB phone number
      Then leads with saved NLB phone number found in LBT
      When admin clicks on leads with saved NLB phone number
      And admin clicks on tab "Data Pemilik & Properti"
      Then Notes should contain "facility"
      And Notes should contain "room_facility"
      And Notes should contain "public_facility"
      And Notes should contain "Penambahan fasilitas test"
