@pman @role-management @test

  Feature: Role Management

    @TEST_PMAN-3690 @continue @pmsContext
    Scenario: Add Role
      Given admin go to pms singgahsini

    @pmsContext1
    Scenario: Test
      Given admin go to pms singgahsini
      When admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |

#      And admin go to role management menu
#      #back from tambah Role
#      When admin go to tambah role
#      And admin set new role "Automation Test"
#        | Akses Homepage - Lihat Detail Properti  |
#        | Akses Homepage - Unduh CSV              |
#        | Akses Ketersediaan Kamar                |
#      But admin back to role management home
#      Then role "Automation Test" should not exist
#      #reset permission
#      When admin go to tambah role
#      And admin set new role "Automation Test"
#        | Akses Disbursement - Approve / Unapprove  |
#        | Akses Disbursement - Edit Transaction     |
#        | Akses Disbursement - Lihat Detail         |
#        | Akses Homepage - Lihat Detail Properti    |
#        | Akses Homepage - Unduh CSV                |
#        | Akses Ketersediaan Kamar                  |
#      But admin reset permission
#      Then all permission are unchecked
#      #Add new Role
#      When admin set new role "Automation Test"
#        | Akses Homepage - Lihat Detail Properti  |
#        | Akses Homepage - Unduh CSV              |
#        | Akses Ketersediaan Kamar                |
#      And admin submit add new role
#      Then system should show toast message "Role berhasil disimpan."
#
#    @TEST_PMAN-3684 @continue @pmsContext
#    Scenario: Search Role
#      When admin search role "Automation Test"
#      Then role "Automation Test" should exist
#
#    @TEST_PMAN-5189 @continue @pmsContext
#    Scenario: Add existing Role
#      When admin go to tambah role
#      And admin set new role "Automation Test"
#        | Akses Disbursement - Approve / Unapprove  |
#        | Akses Disbursement - Edit Transaction     |
#        | Akses Disbursement - Lihat Detail         |
#      And admin submit add new role
#      Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."
#
#    @TEST_PMAN-3687 @continue @pmsContext
#    Scenario: Edit Role
#      When admin go to role management menu
#      #change using existing role name
#      When admin edit role "Automation Test" to "Product PMAN"
#      And admin submit add new role
#      Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."
#      #change to new role name
#      When admin rename role name to "Automation Test PMAN"
#      And admin add permissions
#        | Akses Disbursement - Lihat Detail         |
#        | Akses Disbursement - Approve / Unapprove  |
#      And admin submit add new role
#      Then system should show toast message "Perubahan berhasil disimpan."
#
#    @TEST_PMAN-3685 @continue @pmsContext
#    Scenario: Assign Member to Role
#      #add invalid member
#      When admin assign member "giska@mamiteam.com" to role "Automation Test PMAN"
#      Then system show tambah member error message "Member tidak ditemukan"
#      #add valid member
#      When admin go to role management menu
#      When admin assign member "automationpman01@mamikos.com" to role "Automation Test PMAN"
#      Then member "automationpman01@mamikos.com" should registered
#
#    @TEST_PMAN-3689 @pmsContext1
#    Scenario: Check Button Availability According to Permissions
#      Given admin go to pms singgahsini
#      When admin login pms :
#        | email             | password      |
#        | pman@mamiteam.com | pmanM4m1t34m  |

#    @TEST_PMAN-3695 @continue @pmsContext
#    Scenario: Delete Member
#      #cancel delete member
#      When admin delete member "automationpman01@mamikos.com"
#      But admin cancel confirmation to delete
#      Then member "automationpman01@mamikos.com" still registered
#      #confiem delete member
#      When admin delete member "automationpman01@mamikos.com"
#      But admin confirm to delete member
#      Then member "automationpman01@mamikos.com" not registered
#
#    @TEST_PMAN-5322 @pmsContext1
#    Scenario: Check Button Availability According to Permissions
#
#
#    @TEST_PMAN-3692
#    Scenario: Delete Role
#      When admin go to role management menu
#      And admin delete role "Automation Test PMAN"
#      Then role "Automation Test PMAN" should not exist