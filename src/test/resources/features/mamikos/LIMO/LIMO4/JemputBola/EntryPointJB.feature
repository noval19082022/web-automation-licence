@regression @LIMO4
Feature: Entry Point Jemput Bola

  @TEST_LIMO-4960 @TEST_LIMO-4953 @TEST_LIMO-4954
  Scenario Outline: Check entry point jemput bola apartment and kost mamiads on & off
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag     | phone prod      | password     |
      | <phone number> | <phone number>  | qwerty123    |
    And owner navigate to mamiads dashboard
    And user close mamiads onboarding popup
    Then user will see entry point jemput bola
    Examples:
      | phone number   |
      | 0822977400004  |
      | 082180680001   |
      | 081280680002   |

    @TEST_LIMO-4982
    Scenario: Show label "baru" when owner visit this section for the first time
      Given user go to mamikos homepage
      When user login as owner:
        | phone stag   | phone prod    | password     |
        | 082180680001 | 082180680001  | qwerty123    |
      And owner navigate to mamiads dashboard
      And user close mamiads onboarding popup
      Then user will see label baru on JB entry point is "visible"
      When user click on jemput bola entry point
      And user go back to previous page
      Then user will see label baru on JB entry point is "not visible"