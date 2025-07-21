@singgahsini @regression @pman @pman-prod

Feature: Kost List History

  @TEST_SS-588
  Scenario: Admin - Verify Component of Page Kost List
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman01@mamikos.com | qwerty123 |
    And admin access menu "Kost List" sub menu of management level
    And admin search kost by name for check Room List
    And admin clicks on Kost List History
    Then show kost list history room name properly
    And show kost list history owner name properly
    And kost list history column contains
      | Log     |
      | Actor   |
      | Created |
