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
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "8239231283"
    Then user verify OTP verification message was sent "Kami telah mengirimkan Kode OTP ke nomor 08239231283"

  @TEST_DOM-394
  Scenario: [Tenant][Phone Number - verifikasi page]when Phone number is empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user empty phone number field
    Then user get error message "Nomor Handphone harus diisi."

  @TEST_DOM-386
  Scenario: Verification - Email already registered
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "tenantmars@gmail.com"
    Then user get error message "Email sudah digunakan oleh akun lain"

  @TEST_DOM-387
  Scenario: Verification - Email with wrong format
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "qaautomation@mamikos"
    Then user get error message "Email harus berupa alamat surel yang benar."

  @TEST_DOM-334
  Scenario: Verification - Kirim ulang OTP Message
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "8239231283"
    Then user verify OTP countdown message was sent "Mohon tunggu untuk mengirim ulang kode OTP ?"

  @TEST_DOM-389
  Scenario: Verification - when empty email
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user empty email address field
    Then user get error message "Email harus diisi."

  @TEST_DOM-346
  Scenario: Verification - input number < 8
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with condition into "8112069"
    Then user get error message "Nomor Handphone minimal mengandung 8 karakter."

  @TEST_DOM-333
  Scenario: Verification - input number > 14
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "81120699900000"
    Then user get error message "Maaf, Nomor tidak valid, silahkan gunakan nomor yang lain"

  @TEST_DOM-332
  Scenario: Verification - phone number already exist
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "898765432166"
    Then user get error message "Maaf nomor sudah terdaftar"

  Scenario: Verification - Email is not correct
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "tenantmars@gmail.comm"
    Then user get error message "Format email tidak sesuai"

  Scenario: Verification - input using alphabet
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password     |
      | 083311231113 | 083311231113 | asdf1234     |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with condition into "qwertyuiop"
    Then user get error message "Nomor Handphone harus berupa angka."