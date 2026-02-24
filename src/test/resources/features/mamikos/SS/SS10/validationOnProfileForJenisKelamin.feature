@SS8 @update-profile
Feature: Check field required on update profile form

  @TEST_SS-3890
  Scenario: Check field required on update profile form
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod | password  |
      | 0813000003 | 0813000003 | qwerty123 |
    And tenant navigates to edit profile
    Then user can see "Wajib diisi" on profile page "0"
    When user can see "Wajib diisi" on profile page "1"
    Then user see button simpan edit profile disable