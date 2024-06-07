@DOM3 @changePasswordOwner
Feature: Change password owner

  @TEST_COOP-5330 @continue
  Scenario: Change password with wrong old password
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password      |
      | 0888881289    | qamamikos123  |
    And owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty1234"
    And owner fills new password "asdf1234"
    And user clicks on simpan password button
    Then user get error message "Password Lama Anda tidak valid."

  @TEST_COOP-5331 @continue
  Scenario: Owner change password more than 25 characters
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "qwerty12345678901234567890123"
    Then user get error message "Password lebih dari 25 karakter."

  @TEST_COOP-5332 @continue
  Scenario: Owner change password less than 8 characters
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "qwe123"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_COOP-5333 @continue
  Scenario: Owner change password only using alphabet
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "qwertyuiop"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_COOP-5334 @continue
  Scenario: Owner change password only using number
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "1234567891"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_COOP-5335 @continue
  Scenario: Owner change password with special character
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "!@#$%^&*()"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_COOP-5336 @continue
  Scenario: Owner empty old password field
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "asdf1234"
    And owner empty old password field
    Then user get error message "Masukkan password."

  @TEST_COOP-5337
  Scenario: Owner empty old password field
    Given owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "asdf1234"
    And owner empty new password field
    Then user get error message "Masukkan password."

  @TEST_COOP-5338
  Scenario: Owner success change password
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password   |
      | 0888881291    | qwerty123  |
    And owner navigates to Akun menu
    And owner click on Ubah "Password"
    And owner fills old password "qwerty123"
    And owner fills new password "asdf1234"
    And user clicks on simpan password button
    And owner click on Ubah "Password"
    And owner fills old password "asdf1234"
    And owner fills new password "qwerty123"
    Then user clicks on simpan password button