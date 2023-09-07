@pman @role-management

  Feature: Role Management

    @TEST_PMAN-3690 @continue
    Scenario: Add Role
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to role management menu
      #back from tambah Role
      When admin go to tambah role
      And admin set new role "Automation Test"
        | Akses Homepage - Lihat Detail Properti  |
        | Akses Homepage - Unduh CSV              |
        | Akses Ketersediaan Kamar                |
      But admin back to role management home
      Then role "Automation Test" should not exist
      #reset permission
      When admin go to tambah role
      And admin set new role "Automation Test"
        | Akses Disbursement - Approve / Unapprove  |
        | Akses Disbursement - Edit Transaction     |
        | Akses Disbursement - Lihat Detail         |
        | Akses Homepage - Lihat Detail Properti    |
        | Akses Homepage - Unduh CSV                |
        | Akses Ketersediaan Kamar                  |
      But admin reset permission
      Then all permission are unchecked
      #Add new Role
      When admin set new role "Automation Test"
        | Akses Homepage - Lihat Detail Properti  |
        | Akses Homepage - Unduh CSV              |
        | Akses Ketersediaan Kamar                |
      And admin submit add new role
      Then system should show toast message "Role berhasil disimpan."

    @TEST_PMAN-3684 @continue
    Scenario: Search Role
      When admin search role "Automation Test"
      Then role "Automation Test" should exist

    @TEST_PMAN-5189 @continue
    Scenario: Add existing Role
      When admin go to tambah role
      And admin set new role "Automation Test"
        | Akses Disbursement - Approve / Unapprove  |
        | Akses Disbursement - Edit Transaction     |
        | Akses Disbursement - Lihat Detail         |
      And admin submit add new role
      Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."

    @TEST_PMAN-3687 @continue
    Scenario: Edit Role
      When admin go to role management menu
      #change using existing role name
      When admin edit role "Automation Test" to "Product PMAN"
      And admin submit add new role
      Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."
      #change to new role name
      When admin rename role name to "Automation Test PMAN"
      And admin add permissions
        | Akses Disbursement - Lihat Detail         |
        | Akses Disbursement - Approve / Unapprove  |
      And admin submit add new role
      Then system should show toast message "Perubahan berhasil disimpan."

    @TEST_PMAN-3692
    Scenario: Delete Role
      When admin go to role management menu
      And admin delete role "Automation Test PMAN"
      Then role "Automation Test PMAN" should not exist