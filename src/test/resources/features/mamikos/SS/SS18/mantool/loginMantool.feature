@regression @essentialTest2 @SS16 @mantool

Feature: Login Mantool

  @TEST_SS-941
  Scenario: Login using invalid credential
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140888      | qwerty123 |
    Then show login mantool error message "Nomor Handphone atau Password tidak sesuai."

  @TEST_SS-949
  Scenario: Login agen akuisisi
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140880      | qwerty123 |
    Then should redirect to onboarding page
    And step section header is "Langkah Awal Agen Akuisisi"

  @TEST_SS-959
  Scenario: Login agen akuisisi using old account
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 082212340909      | qwerty123 |
    Then should redirect to onboarding page
    And step section header is "Langkah Awal Agen Akuisisi"

  @TEST_SS-958
  Scenario: Login agen input data
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140881      | qwerty123 |
    Then should redirect to onboarding page
    And step section header is "Langkah Awal Agen Input Data"

  @TEST_SS-925 @continue
  Scenario: Login agen input data using old account
    Given admin navigate to mantool
    When admin login agen mantool
      | No Handphone stag | password  |
      | 083214140884      | qwerty123 |
    Then should redirect to onboarding page
    And step section header is "Langkah Awal Agen Input Data"

  @TEST_SS-939 @continue
  Scenario: Agen visit LCT
    When agen click button "Link Leads Mamikos"
    Then agen should redirect to "https://jambu.kerupux.com/leads/agen/leads-management?activeTab=submitted" in new tab
    And admin close unused browser tab

  @TEST_SS-932 @continue
  Scenario: Logout from onboarding page
    When agen logout from onboarding page
    Then agen should redirect to mantool landing page

  @TEST_SS-933 @continue
  Scenario: Visit onboarding page after logout
    When agen visit onboarding page agen
    Then agen should redirect to mantool landing page

  @TEST_SS-940
  Scenario: Visit LCT after logout
    When agen visit LCT
    Then agen should redirect to mantool landing page