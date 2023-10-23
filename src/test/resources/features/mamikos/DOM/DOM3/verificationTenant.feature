@DOM3 @verificationTenant

Feature: Verification Tenant

  @TEST_DOM-174
  Scenario: [Web Tenant][email validation] User verification from incoming email
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 083311231113  | 083311231113 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "aiueoo@gmail.com"
    And user go to mailhog and login
    Then user confirm change email

  @TEST_DOM-1830
  Scenario: [Web Tenant][phone number - verifikasi page ] Change Phone number data valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | qamamikos123 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "8239231283"
    Then user verify OTP verification message was sent "Kami telah mengirimkan Kode OTP ke nomor 08239231283"