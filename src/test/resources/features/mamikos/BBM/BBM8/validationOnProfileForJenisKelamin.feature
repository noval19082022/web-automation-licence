@BBM8 @update-profile
Feature: Check field required on update profile form

  @TEST_BBM-26
  Scenario: Check field required on update profile form
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    |  phone prod    | password  |
      | 089220221221  |  089220221221  | qwerty123 |
    And tenant navigates to edit profile
    Then user can see "Jenis kelamin tidak boleh kosong" on profile page
    When user can see "Tanggal lahir belum diisi." on profile page
    Then user see button simpan edit profile disable