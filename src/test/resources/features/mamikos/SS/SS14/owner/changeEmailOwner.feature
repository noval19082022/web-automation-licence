@SS14 @changeEmailOwner
Feature: Change email owner

  @TEST_SS-3273
  Scenario: Change email owner using registered email
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password     |
      | 0888881289 | qamamikos123 |
    And owner navigates to Akun menu
    And owner click on Ubah "Email"
    And owner change email to "plmrega123@mailinator.com"
    Then user get error message "Email sudah digunakan oleh akun lain"

  @continue @TEST_SS-3270
  Scenario: Change email owner
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password  |
      | 0888881281 | qamamikos |
    And owner navigates to Akun menu
    And owner click on Ubah "Email"
    And owner change email to "coopowneraAT@mailinator.com"
    Then owner will see toast "Mohon cek email yang baru Anda masukkan untuk verifikasi."

  @TEST_SS-3271
  Scenario: Retry change email owner within 1 minute
    Given owner navigates to Akun menu
    And owner click on Ubah "Email"
    And owner change email to "coopowneraAT@mailinator.com"
    Then owner will see toast "Terjadi Galat. Silahkan coba lagi atau tunggu beberapa menit."

  @TEST_SS-3262
  Scenario: Change email owner using wrong format
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 081328787343 | qwerty123 |
    And owner navigates to Akun menu
    And owner click on Ubah "Email"
    And owner change email to "coop124@mailinator"
    Then user get error message "Format email tidak sesuai"

  @TEST_SS-3263
  Scenario: Change email owner using invalid email
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | password     |
      | 0888881289 | qamamikos123 |
    And owner navigates to Akun menu
    And owner click on Ubah "Email"
    And owner change email to "Coop123@phdaily.com"
    Then user get error message "Mohon masukkan email yang valid"