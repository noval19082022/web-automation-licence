@pman @role-management @add-permission

Feature: Adding Permission on Disbursement Management

  @TEST_PMAN-4551 @continue @context1 @context2
  Scenario: User add Lihat Detail Disbursement permission
    Given owner set browser context to "context1"
    And bring page to front
    And admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to role management menu
      #add role
    When admin go to tambah role
    And admin set new role "Automation Test Add Permission"
      | Akses Disbursement - Lihat Detail         |
    And admin submit add new role
    Then system should show toast message "Role berhasil disimpan."
    And role "Automation Test Add Permission" should exist
      #assign member
      ##add valid member
    When admin assign member "automationpman02@mamikos.com" to role "Automation Test Add Permission"
    Then member "automationpman02@mamikos.com" should registered

  @TEST_PMAN-4551 @continue
  Scenario: User add Lihat Detail Disbursement permission
    #check Lihat Detail button availability
    ##login on different browser using assigned member
    Given owner set browser context to "context2"
    And bring page to front
    When admin go to pms singgahsini
    And admin login pms :
      | email                         | password   |
      | automationpman02@mamikos.com  | qwerty123  |
    And admin go to Disbursement menu
    And admin Filter Status Data Pendapatan "Menunggu Konfirmasi"
    Then admin automation has permission on Disbursement for button
      | Lihat Detail  |

  @TEST_PMAN-6921 @continue
  Scenario: User add Approve Disbursement permission
    Given owner set browser context to "context1"
    And bring page to front
    And admin go back to role management page
      #edit and add permission
    When admin search role "Automation Test Add Permission"
    And admin edit and add permission
      | Akses Disbursement - Approve / Unapprove  |
    And admin submit add new role
    Then system should show toast message "Perubahan berhasil disimpan."

  @TEST_PMAN-6921
  Scenario: User add Approve Disbursement permission
    #check Konfirmasi & Lihat Detail button availability
    ##login on different browser using assigned member
    Given owner set browser context to "context2"
    And bring page to front
    And admin go to Disbursement menu and refresh page
    And admin Filter Status Data Pendapatan "Menunggu Konfirmasi"
    Then admin automation has permission on Disbursement for button
      | Konfirmasi    |
      | Lihat Detail  |