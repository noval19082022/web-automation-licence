@ss2 @role-management

Feature: Role Management

  @TEST_SS-829 @continue @context1 @context2
  Scenario: Add Role
    Given owner set browser context to "context1"
    And bring page to front
    And admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to role management menu
      #back from tambah Role
    When admin go to tambah role
    And admin set new role "Automation Test"
      | Akses Homepage - Lihat Detail Properti |
      | Akses Homepage - Unduh CSV             |
      | Akses Ketersediaan Kamar               |
    But admin back to role management home
    Then role "Automation Test" should not exist
      #reset permission
    When admin go to tambah role
    And admin set new role "Automation Test"
      | Akses Disbursement - Approve / Unapprove |
      | Akses Disbursement - Edit Transaction    |
      | Akses Disbursement - Lihat Detail        |
      | Akses Homepage - Lihat Detail Properti   |
      | Akses Homepage - Unduh CSV               |
      | Akses Ketersediaan Kamar                 |
    But admin reset permission
    Then all permission are unchecked
      #Add new Role
    When admin set new role "Automation Test"
      | Akses Homepage - Lihat Detail Properti |
      | Akses Homepage - Unduh CSV             |
      | Akses Ketersediaan Kamar               |
    And admin submit add new role
    Then system should show toast message "Role berhasil disimpan."

  @TEST_SS-857 @continue
  Scenario: Search Role
    When admin search role "Automation Test"
    Then role "Automation Test" should exist

  @TEST_SS-753 @continue
  Scenario: Add existing Role
    When admin go to tambah role
    And admin set new role "Automation Test"
      | Akses Disbursement - Approve / Unapprove |
      | Akses Disbursement - Edit Transaction    |
      | Akses Disbursement - Lihat Detail        |
    And admin submit add new role
    Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."

  @TEST_SS-811 @continue
  Scenario: Edit Role
    When admin go to role management menu
      #change using existing role name
    When admin edit role "Automation Test" to "Product PMAN"
    And admin submit add new role
    Then system show nama role error message "Nama role sudah digunakan. Masukkan nama role yang lain."
      #change to new role name
    When admin rename role name to "Automation Test PMAN"
    And admin add permissions
      | Akses Disbursement - Lihat Detail        |
      | Akses Disbursement - Approve / Unapprove |
    And admin submit add new role
    Then system should show toast message "Perubahan berhasil disimpan."

  @TEST_SS-872 @continue
  Scenario: Assign Member to Role
      #add invalid member
    When admin assign member "giska@mamiteam.com" to role "Automation Test PMAN"
    Then system show tambah member error message "Member tidak ditemukan"
      #add valid member
    When admin go to role management menu
    When admin assign member "automationpman01@mamikos.com" to role "Automation Test PMAN"
    Then member "automationpman01@mamikos.com" should registered

  @TEST_SS-809 @continue
  Scenario: User can access PMS according to their role
    Given owner set browser context to "context2"
    And bring page to front
    When admin go to pms singgahsini
    And admin login pms :
      | email                        | password  |
      | automationpman01@mamikos.com | qwerty123 |
    #check permission homepage
    Then admin automation have permission for button
      | Lihat Detail       |
      | Ketersediaan Kamar |
      | Unduh CSV          |

  @TEST_SS-832 @continue
  Scenario: Delete Member
    Given owner set browser context to "context1"
    And bring page to front
      #cancel delete member
    When admin delete member "automationpman01@mamikos.com"
    But admin cancel confirmation to delete
    Then member "automationpman01@mamikos.com" still registered
      #confirm delete member
    When admin delete member "automationpman01@mamikos.com"
    But admin confirm to delete member
    Then member "automationpman01@mamikos.com" not registered

  @TEST_SS-771 @continue
  Scenario: User can't access some Menu in PMS according to their role
    Given owner set browser context to "context2"
    And bring page to front
    When admin refresh page 0
    Then admin automation doesn't have permission for button
      | Lihat Detail       |
      | Ketersediaan Kamar |
      | Unduh CSV          |

  @TEST_SS-826
  Scenario: Delete Role
    Given owner set browser context to "context1"
    And bring page to front
    When admin go to role management menu
    And admin delete role "Automation Test PMAN"
    Then role "Automation Test PMAN" should not exist
