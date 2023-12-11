@regression @LIMO3 @listing-monetization @changeOwnerName
Feature: Owner Setting - Change Owner Name

  @TEST_LIMO-3217 @continue
  Scenario: Change Owner Name
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password   |
      | 0812345670001 | qwerty123  |
    And owner navigates to Akun menu
    And owner click on Ubah "Nama Lengkap"
    And owner fills nama lengkap owner "Change name test"
    Then verify nama lengkap owner
    When owner click on Ubah "Nama Lengkap"
    And owner fills nama lengkap owner "tiara"
    Then verify nama lengkap owner

  @TEST_LIMO-2842
  Scenario: [Setelan Akun] Text box "Nama" is inputed with invalid value
    When owner click on Ubah "Nama Lengkap"
    And owner fills nama lengkap owner "7777 88"
    Then verify pop up message "Mohon masukkan karakter alfabet"
    When owner fills nama lengkap owner "+-=*%"
    Then verify pop up message "Mohon masukkan karakter alfabet"
    When owner delete nama lengkap owner
    And owner fills nama lengkap owner "yu"
    Then verify pop up message "Minimal 3 karakter"