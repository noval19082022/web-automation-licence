@regression @essentialTest2 @pman3 @mantool

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

    @TEST_SS-958
    Scenario: Login agen input data
      Given admin navigate to mantool
      When admin login agen mantool
        | No Handphone stag | password  |
        | 083214140881      | qwerty123 |
      Then should redirect to onboarding page
      And step section header is "Langkah Awal Agen Input Data"