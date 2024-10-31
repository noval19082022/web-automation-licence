@regression @pman3 @ss @harvest @roleManagement

  Feature: Tambah Role Harvest

    @TEST_SS-5103 @continue
    Scenario: Find member by name
      When admin navigates to Harvest Dashboard Login
      And admin login Harvest Dashboard:
        | email             | password      |
        | pman@mamiteam.com | pmanM4m1t34m  |
      When admin add new role harvest "Automation"
      And admin search member "upr"
      Then system should show member suggestion "Upras Hanif Marfuah (upras@mamikos.com)"
      When admin search member "Yudha"
      Then system should show member suggestion "Yudha (yudha@mamiteam.com)"

    @TEST_SS-5104
    Scenario: Find member by email
      When admin change search member search by "Email"
      And admin search member "wid"
      Then system should show member suggestion "Rini Widyarini (widyarini@mamikos.com)"
      When admin search member "yudha@mamikos.com"
      Then system should show member suggestion "Yudha Ferroza Hadi Kus Chandra (yudha@mamikos.com)"