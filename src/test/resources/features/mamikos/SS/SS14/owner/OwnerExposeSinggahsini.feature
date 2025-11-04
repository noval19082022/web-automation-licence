@LIMO6
Feature: Owner Expose Singgahsini

  @TEST_SS-9797
  Scenario: [Web][Owner Dashboard][Singgahsini ID]Check Info untuk anda section and redirection when login owner p2 but don't have active kost
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239002 | 089604239002 | qwerty123 |
    Then owner should see expose singgahini link
    When owner click on expose singgahsini link
    Then user navigates to singgahsini.id

  @TEST_SS-9798
  Scenario: [Web][Owner Dashboard][Singgahsini ID]Check Info untuk anda section and redirection when login owner p2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod   | password  |
      | 089604239001 | 089604239002 | qwerty123 |
    Then owner should see expose singgahini link
    When owner click on expose singgahsini link
    Then user navigates to singgahsini.id
