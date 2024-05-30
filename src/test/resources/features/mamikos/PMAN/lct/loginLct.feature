@regression @essentialTest2 @pman3 @pman-prod @lct

  Feature: Login LCT

    @TEST_PMAN-9689
    Scenario: Login as BD
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | phone prod    | password      |
        | 089966561211  | 0890000003480 | Bismillah@01  |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "business development"

    @TEST_PMAN-9690
    Scenario: Login as MDR
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | phone prod    | password      |
        | 089966561212  | 0890000003481 | Bismillah@01  |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "market development representative"

    @TEST_PMAN-9691
    Scenario: Login as AO
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag    | phone prod    | password     |
        | 089966561213  | 0890000003479 | Bismillah@01 |
      Then owner should have menu "Leads"
      When owner click leads menu
      Then owner should redirect to lct
      And owner role should be "agent offline"
