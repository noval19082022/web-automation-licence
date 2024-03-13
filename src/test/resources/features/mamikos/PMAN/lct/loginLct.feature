@regression @pman @lct

  Feature: Login LCT

    Scenario: Login as BD
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password  |
        | 089966561211  |  089966561211  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "business development"

    Scenario: Login as MDR
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password  |
        | 089966561212  |  089966561211  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "MDR"

    Scenario: Login as AO
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    |  phone prod    | password  |
        | 089966561213  |  089966561211  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "AO"
