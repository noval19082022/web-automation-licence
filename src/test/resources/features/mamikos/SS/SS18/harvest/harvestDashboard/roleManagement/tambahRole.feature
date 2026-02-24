@regression @SS16 @ss @harvest @roleManagement

Feature: Tambah Role Harvest

  @TEST_SS-5103 @continue
  Scenario: Find member by name using 3 letter
    When admin navigates to Harvest Dashboard Login
    And admin login Harvest Dashboard:
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    When admin add new role harvest "Automation"
    And admin search member "upr"
    Then system should show member suggestion "Upras Hanif Marfuah (upras@mamikos.com)"

  @TEST_SS-5105 @continue
  Scenario: Find member by name using full name
    When admin search member "Upras Hanif Marfuah"
    Then system should show member suggestion "Upras Hanif Marfuah (upras@mamikos.com)"
    When admin choose member "Upras Hanif Marfuah (upras@mamikos.com)"
    Then member "Upras" should add in list member

  @TEST_SS-5104 @continue
  Scenario: Find member by email using 3 letter
    Given admin delete list member
    When admin change search member search by "Email"
    And admin search member "wid"
    Then system should show member suggestion "Rini Widyarini (widyarini@mamikos.com)"

  @TEST_SS-5106
  Scenario: Find member by email using full email
    When admin search member "yudha@mamikos.com"
    Then system should show member suggestion "Yudha Ferroza Hadi Kus Chandra (yudha@mamikos.com)"
    When admin choose member "Yudha Ferroza Hadi Kus Chandra (yudha@mamikos.com)"
    Then member "Yudha Ferroza" should add in list member
