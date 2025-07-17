@regression @LIMO3 @listing-monetization @changeOwnerNumber @DONEMIGRATINGTONEWBOARD
Feature: Owner Setting - Change Owner Number

  @noInputNumber @continue @TEST_LIMO-871
  Scenario: Change Owner Number - No input phone number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 087133998156 | qwerty123 |
    And owner navigates to Akun menu
    And owner click on Ubah "Nomor Handphone"
    Then owner delete nomor handphone owner

  @numberRegisteredOwnerNewFlow @continue @TEST_LIMO-870
  Scenario: Change Owner Number - Input registered owner number new flow
    And owner fills nomor handphone owner "0891202103"
    Then verify pop up message "The phone number has already been taken."

  @numberSpecialCharacterAndNumeric @continue @TEST_LIMO-869
  Scenario: Change Owner Number - Special character and numeric
    And owner fills nomor handphone owner "08134564!@#$%"
    Then verify pop up message "Nomor handphone harus diawali dengan 08."

  @resendCodeVerification @TEST_LIMO-868
  Scenario: Change Owner Number - Resend code verification
    And owner fills nomor handphone owner "08912021100"
    Then verify pop up input valid nomor handphone