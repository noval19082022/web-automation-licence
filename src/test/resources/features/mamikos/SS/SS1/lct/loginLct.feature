@regression @essentialTest2 @SS11 @SS1-prod @lct

Feature: Login LCT

  @TEST_SS-621 @continue
  Scenario: Login as BD
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | No Handphone prod | password     |
      | 089966561211      | 0890000003480     | Bismillah@01 |
    Then should redirect to onboarding page
    When agen click button "Link Leads Mamikos"
    Then agen should redirect to "LCT" in new tab
    And agen role should be "business development"

  @TEST_SS-619 @continue
  Scenario: Login as MDR
    Given admin close unused browser tab
    And admin logout mantool
    When admin login agen mantool
      | No Handphone stag | No Handphone prod | password     |
      | 089966561212      | 0890000003481     | Bismillah@01 |
    Then should redirect to onboarding page
    When agen click button "Link Leads Mamikos"
    Then agen should redirect to "LCT" in new tab
    And agen role should be "market development representative"

  @TEST_SS-626
  Scenario: Login as AO
    Given admin close unused browser tab
    And admin logout mantool
    When admin login agen mantool
      | No Handphone stag | No Handphone prod | password     |
      | 089966561213      | 0890000003479     | Bismillah@01 |
    Then should redirect to onboarding page
    When agen click button "Link Leads Mamikos"
    Then agen should redirect to "LCT" in new tab
    And agen role should be "agent offline"