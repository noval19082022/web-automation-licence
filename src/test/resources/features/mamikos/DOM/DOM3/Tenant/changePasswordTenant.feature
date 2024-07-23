@DOM3 @changePasswordTenant
Feature: Change password tenant

  @TEST_SS-3028 @continue
  Scenario: [Tenant] Change password more than 25 characters
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 083311231114  | 083311231113 | asdf1234 |
    And user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "qwerty12345678901234567890123"
    Then user get error message "Password lebih dari 25 karakter."

  @TEST_SS-3029 @continue
  Scenario: Change password with special character
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "!@#$%^&*"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_SS-3030 @continue
  Scenario: Change password less than 8 characters
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "abc17"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_SS-3031 @continue
  Scenario: Change password only using alphabet
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "qwertyuiop"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_SS-3032 @continue
  Scenario: Change password only using number
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "1234567891"
    Then user get error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

  @TEST_SS-3033 @continue
  Scenario: [Tenant] Change New password same with old password
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "asdf1234"
    Then user get error message "Password tidak boleh sama"

  @TEST_SS-3034 @continue
  Scenario: [Tenant] Change New password and confirm password not match
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "abcde1234"
    Then user get error message "Password tidak sama"

  @TEST_SS-3039 @continue
  Scenario: Change password with wrong old password
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "abcde1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user clicks on simpan password button
    Then user get error message "Password lama tidak valid"

  @TEST_SS-3036 @continue
  Scenario: Empty old password field
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "abcde1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user empty the old password field
    Then user get error message "Masukkan password."

  @TEST_SS-3037 @continue
  Scenario: Empty new password field
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "abcde1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user empty the new password field
    Then user get error message "Masukkan password."

  @TEST_SS-3038 @continue
  Scenario: Empty confirmation password field
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "abcde1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user empty the confirmation password field
    Then user get error message "Masukkan password."

    @TEST_SS-3048
  Scenario: [Tenant] Success change password
    Given user navigate to kost saya page
    And user clicks on pengaturan button
    And user fills password lama "asdf1234"
    And user fills password baru "qwerty123"
    And user fills ketik ulang password "qwerty123"
    And user clicks on simpan password button
    And user clicks on pengaturan button
    And user fills password lama "qwerty123"
    And user fills password baru "asdf1234"
    And user fills ketik ulang password "asdf1234"
    Then user clicks on simpan password button