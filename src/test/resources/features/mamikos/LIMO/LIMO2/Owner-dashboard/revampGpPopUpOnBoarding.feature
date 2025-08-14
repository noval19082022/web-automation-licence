@LIMO02 @revampGpOnboarding
Feature: Revamp GP Onboarding

  @resetGP @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "08159787775"

  @TEST_LIMO-9180 @continue
  Scenario: [Revamp GP Onboarding] Target Audience Validation - Owner has never purchased GP 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08159787775 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then Owner see gp onboarding pop up is exist

  @TEST_LIMO-9183 @continue
  Scenario: [Revamp GP Onboarding] Verify Swipeable Content Functionality
    And Owner swap the gp pop up onboarding

  @TEST_LIMO-9183
  Scenario: [Revamp GP Onboarding] Verify 3 Dots Indicator Display and Behavior
    And Owner swap the gp pop up onboarding 3 times

  @TEST_LIMO-9181
  Scenario: [Revamp GP Onboarding] Non Target Audience Verification - Owner has previously owned GP 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08119787890 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then Owner see gp onboarding pop up is not exist