@regression @SS16 @harvest

Feature: Harvest Menu

  @TEST_SS-895
  Scenario: Check Sidebar Menu
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    Then admin should redirect to All leads menu
    When admin click sidebar menu "P2 Leads"
    Then admin should redirect to harvest "p2-leads"
    When admin click sidebar menu "Setting Area Priority"
    Then admin should redirect to harvest "setting-area-priority"
    When admin click sidebar menu "Role Management"
    Then admin should redirect to harvest "role-management?page=1"

  @TEST_SS-8619 @continue
  Scenario: User with permission Edit Leads can see button Manage Leads
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email              | password   |
      | yudha@mamiteam.com | II7ucivwqd |
    Then admin can view "Manage Leads" button

  @TEST_SS-8620 @continue
  Scenario: User with permission Update Status Leads can see button Upload CSV in P2 Leads Menu
    When admin click sidebar menu "P2 Leads"
    Then admin can view "Upload CSV" button

  @TEST_SS-8621
  Scenario: User with permission Upload Area Prio can see button Upload CSV in Setting Area Priority Menu
    When admin click sidebar menu "Setting Area Priority"
    Then admin can view "Upload CSV" button

  @TEST_SS-8622 @continue
  Scenario: User without permission Edit Leads can't see button Manage Leads
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email             | password     |
      | yudha@mamikos.com | yUdh4FerR0za |
    Then admin can't view "Manage Leads" button

  @TEST_SS-8623 @continue
  Scenario: User without permission Update Status Leads can't see button Upload CSV in P2 Leads Menu
    When admin click sidebar menu "P2 Leads"
    Then admin can't view "Upload CSV" button

  @TEST_SS-8624
  Scenario: User without permission Upload Area Prio can't see button Upload CSV in Setting Area Priority Menu
    When admin click sidebar menu "Setting Area Priority"
    Then admin can't view "Upload CSV" button