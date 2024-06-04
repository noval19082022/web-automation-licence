@regression @essentialTest2 @pman3 @pman-prod @lct

  Feature: Login LCT

    @TEST_PMAN-9689
    Scenario: Login as BD
      Given admin navigate to mantool
      When admin login agen mantool
        | No Handphone stag | No Handphone prod | password      |
        | 089966561211      | 0890000003480     | Bismillah@01  |
      Then should redirect to onboarding page
      When agen click button "Link Leads Mamikos"
      Then agen should redirect to "LCT" in new tab
      And agen role should be "business development"

    @TEST_PMAN-9690
    Scenario: Login as MDR
      Given admin navigate to mantool
      When admin login agen mantool
        | No Handphone stag | No Handphone prod | password      |
        | 089966561212      | 0890000003481     | Bismillah@01  |
      Then should redirect to onboarding page
      When agen click button "Link Leads Mamikos"
      Then agen should redirect to "LCT" in new tab
      And agen role should be "market development representative"

    @TEST_PMAN-9691
    Scenario: Login as AO
      Given admin navigate to mantool
      When admin login agen mantool
        | No Handphone stag | No Handphone prod | password      |
        | 089966561213      | 0890000003479     | Bismillah@01  |
      Then should redirect to onboarding page
      When agen click button "Link Leads Mamikos"
      Then agen should redirect to "LCT" in new tab
      And agen role should be "agent offline"