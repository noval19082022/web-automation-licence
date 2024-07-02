@pman2 @role-management

Feature: Empty State Role Management

  @TEST_PMAN-755
  Scenario: Empty State Role Management
    Given admin go to pms singgahsini
    And admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to role management menu
    And admin search role "Super"
    Then empty state is displayed