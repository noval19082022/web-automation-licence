@regression @pman @lct

  Feature: Login LCT

    @TEST_PMAN-9689
    Scenario: Login as BD
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | password  |
        | 089966561211  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "business development"

    @TEST_PMAN-9690
    Scenario: Login as MDR
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | password  |
        | 089966561212  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "market development representative"

    @TEST_PMAN-9691
    Scenario: Login as AO
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | password  |
        | 089966561213  | qwerty123 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "agent offline"
