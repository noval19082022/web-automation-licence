@regression @LIMO3 @listing-monetization @changeOwnerNumber
Feature: Owner Setting - Change Owner Number

  @noInputNumber @continue
  Scenario: Change Owner Number - No input phone number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password   |
      | 087133998156  | qwerty123  |
    And owner navigates to Akun menu
    And owner click on Ubah "Nomor Handphone"
    Then owner delete nomor handphone owner

  @numberRegisteredOwnerNewFlow @LG-9372 @continue
  Scenario: Change Owner Number - Input registered owner number new flow
    And owner fills nomor handphone owner "0891202103"
    Then verify pop up message "The phone number has already been taken."

  @numberSpecialCharacterAndNumeric @continue
  Scenario: Change Owner Number - Special character and numeric
    And owner fills nomor handphone owner "08134564!@#$%"
    Then verify pop up message "Nomor handphone harus diawali dengan 08."

  @resendCodeVerification
  Scenario: Change Owner Number - Resend code verification
    And owner fills nomor handphone owner "08912021100"
    Then verify pop up input valid nomor handphone