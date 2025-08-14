@LIMO02 @revampGpOnboarding
Feature: Revamp GP Onboarding

  @resetGP @continue
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user wants to reset Goldplus for owner with phone number "08159787775"

  @TEST_LIMO-9180
  Scenario: [Revamp GP Onboarding] Target Audience Validation - Owner has never purchased GP 1/2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod | password  |
      | 08159787775 | 0          | qwerty123 |
    And Owner visit Goldplus package without action close the on boarding pop up
    Then Owner see gp onboarding pop up is exist