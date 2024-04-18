@pman @regression @admin @kost-level

  Feature: Kost Level

    @TEST_PMAN-3277
    Scenario: Charging fee can't more than 100%
      Given admin go to mamikos bangkrupux admin
      And admin login to bangkrupux:
        | email stag                    | email prod                    | password        |
        | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
      When admin go to kost level menu
      #add charging fee >100%
      And admin add new kost level "Test Charging Fee" with charging fee "200"
      Then show error message pop up "The charging fee cannot be greater than 100"
      #edit charging fee >100%
      When admin go to kost level menu
      And admin search kost level "test upras"
      And admin edit charging fee to "200"
      Then show error message pop up "The charging fee cannot be greater than 100"