@SS14 @verificationTenant
Feature: Verification Tenant

  @TEST_SS-2949
  Scenario: [Web Tenant][email validation] User verification from incoming email
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "aiueooo@gmail.com"
    And user go to mailhog and login
    Then user confirm change email

  @TEST_SS-2950
  Scenario: [Web Tenant][phone number - verifikasi page ] Change Phone number data valid
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "8239231283"
    Then user verify OTP verification message was sent "Kami telah mengirimkan Kode OTP ke nomor 08239231283"

  @TEST_SS-2951
  Scenario: [Tenant][Phone Number - verifikasi page]when Phone number is empty
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user empty phone number field
    Then user get error message "Nomor Handphone harus diisi."

  @TEST_SS-2952
  Scenario: [Tenant][email - verifikasi] Email already registered
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "tenantmars@gmail.com"
    Then user get error message "Email sudah digunakan oleh akun lain"

  @TEST_SS-2953
  Scenario: [Tenant][email - verifikasi] Email with wrong format
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "qaautomation@mamikos"
    Then user get error message "Email harus berupa alamat surel yang benar."

  @TEST_SS-2954
  Scenario: [Tenant][Phone Number - verifikasi page] Verification - Kirim ulang OTP Message
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "8239231283"
    Then user verify OTP countdown message was sent "Mohon tunggu untuk mengirim ulang kode OTP ?"

  @TEST_SS-2955
  Scenario: [Tenant][email - verifikasi] When empty email
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user empty email address field
    Then user get error message "Email harus diisi."

  @TEST_SS-2956
  Scenario: [Tenant][Phone Number - verifikasi page] Input number < 8
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with condition into "8112069"
    Then user get error message "Nomor Handphone minimal mengandung 8 karakter."

  @TEST_SS-2957
  Scenario: [Tenant][Phone Number - verifikasi page] Input number > 14
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "81120699900000"
    Then user get error message "Maaf, Nomor tidak valid, silahkan gunakan nomor yang lain"

  @TEST_SS-2958
  Scenario: [Tenant][Phone Number - verifikasi page] Phone number already exist
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with "898765432166"
    Then user get error message "Maaf nomor sudah terdaftar"

  @TEST_SS-2959
  Scenario: Verification - Email is not correct
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user change email to "tenantmars@gmail.comm"
    Then user get error message "Format email tidak sesuai"

  @TEST_SS-2960
  Scenario: Verification - input using alphabet
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    And user edit phone number with condition into "qwertyuiop"
    Then user get error message "Nomor Handphone harus berupa angka."

  @TEST_SS-2669 @automated @uxImprovement
  Scenario: [Web][UX Improvement][Tenant Verification account]Update booking microcopy at User page verification description before verified
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod    | password  |
      | 0810000097320 | 0890000000314 | qwerty123 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    Then user can see "Kami melindungi informasi dan penggunaan data diri para pengguna kami." on verifikasi identitas

  @TEST_SS-2670 @automated @uxImprovement
  Scenario: [Web][UX Improvement][Tenant Verification account]Update booking microcopy at User page verification description after verified
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod    | password  |
      | 0810000091 | 0890000000314 | qwerty123 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    Then user can see "Terima kasih, kini kamu dapat menikmati proses Sewa Langsung via Mamikos lebih mudah." on verifikasi identitas

  @TEST_SS-2961
  Scenario: [Web Tenant][email validation] User has not verified their identity
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password |
      | 083311231115 | 083311231115 | asdf1234 |
    And user navigate to kost saya page
    And user open verifikasi akun menu
    Then user can see "Kamu belum mengunggah foto kartu identitas" on verifikasi identitas