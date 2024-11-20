@pman2 @role-management

  Feature: Cancel Auto Transfer Role Management

    @TEST_SS-6354 @continue @context1 @context2
    Scenario: Add value Cancel Auto Transfer in permission list
      Given owner set browser context to "context1"
      And bring page to front
      When admin go to pms singgahsini
      And admin login pms :
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      And admin go to role management menu
      And admin go to tambah role
      Then permission "Akses Disbursement - Cancel Auto Transfer" should exist in permission list

    @TEST_SS-6356 @continue
    Scenario: Add role cancel auto transfer
      And admin set new role "Cancel Auto Transfer Automated"
        | Akses Disbursement - Cancel Auto Transfer |
      And admin submit add new role
      Then system should show toast message "Role berhasil disimpan."
      And role "Cancel Auto Transfer Automated" should exist

    @TEST_SS-6355 @continue
    Scenario: Add member to role cancel auto transfer
      When admin assign member "automationpman02@mamikos.com" to role "Cancel Auto Transfer Automated"
      Then member "automationpman02@mamikos.com" should registered
      #verify permission applied
      Given owner set browser context to "context2"
      And bring page to front
      When admin go to pms singgahsini
      And admin login pms :
        | email                         | password   |
        | automationpman02@mamikos.com  | qwerty123  |
      And admin go to Disbursement menu
      Then cancel auto transfer disbursement button is visible

    @TEST_SS-6357 @continue
    Scenario: Remove permission Cancel Auto Transfer
      Given owner set browser context to "context1"
      And bring page to front
      When admin go to role management menu
      And admin search role "Cancel Auto Transfer Automated"
      And admin edit and untick permission
        | Akses Disbursement - Cancel Auto Transfer  |
      And admin submit add new role
      Then system should show toast message "Perubahan berhasil disimpan."
      #verify permission removed
      Given owner set browser context to "context2"
      And bring page to front
      When admin refresh page 0
      Then cancel auto transfer disbursement button is not visible
      #add permission cancel auto transfer
      Given owner set browser context to "context1"
      And bring page to front
      When admin go to role management menu
      And admin search role "Cancel Auto Transfer Automated"
      And admin edit and add permission
        | Akses Disbursement - Cancel Auto Transfer  |
      And admin submit add new role
      Then system should show toast message "Perubahan berhasil disimpan."
      #verify permission applied
      Given owner set browser context to "context2"
      And bring page to front
      When admin refresh page 0
      Then cancel auto transfer disbursement button is visible

    @TEST_SS-6358 @continue
    Scenario: Remove member Cancel Auto Transfer
      Given owner set browser context to "context1"
      And bring page to front
      When admin go to role management menu
      And admin search role "Cancel Auto Transfer Automated"
      And admin atur member role
      And admin delete member "automationpman02@mamikos.com"
      But admin confirm to delete member
      Then member "automationpman02@mamikos.com" not registered
      #verify permission removed
      Given owner set browser context to "context2"
      And bring page to front
      When admin refresh page 0
      Then cancel auto transfer disbursement button is not visible

    @TEST_SS-6360
    Scenario: Delete role cancel auto transfer
      Given owner set browser context to "context1"
      And bring page to front
      When admin go to role management menu
      And admin delete role "Cancel Auto Transfer Automated"
      Then role "Cancel Auto Transfer Automated" should not exist