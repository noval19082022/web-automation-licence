@regression @pman3 @harvest

  Feature: Harvest Menu

    @TEST_SS-895
    Scenario: Check Sidebar Menu
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email              | password  |
        | pman@mamiteam.com  | pmanM4m1t34m |
      Then admin should redirect to All leads menu
      When admin click sidebar menu "P2 Leads"
      Then admin should redirect to harvest "p2-leads"
      When admin click sidebar menu "Setting Area Priority"
      Then admin should redirect to harvest "setting-area-priority"
      When admin click sidebar menu "Role Management"
      Then admin should redirect to harvest "role-management"