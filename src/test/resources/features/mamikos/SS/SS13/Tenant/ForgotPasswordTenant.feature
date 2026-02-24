@SS14 @forgotPasswordTenant
Feature: Tenant Forgot Password

  @forgotPasswordTenantViaSms @TEST_SS-2926
  Scenario: [Web Tenant][Forgot Password]Send OTP via SMS
    Given user go to mamikos homepage
    When user click on button masuk pencari kos
    And user click on lupa password?
    And user fill their registered phone number "0892202305"
    And user choose verification by sms
    Then user verify otp form appear on page send OTP "Nomor handphone ini telah terdaftar sebagai akun pencari kos di Mamikos"

#  @forgotPasswordTenantViaWhatsapp @TEST_COOP-5646
#  Scenario: [Web Tenant][Forgot Password]Send OTP via Whatsapp
#    Given user go to mamikos homepage
#    When user click on button masuk pencari kos
#    And user click on lupa password?
#    And user fill their registered phone number "0892202305"
#    And user choose verification by WA
#    Then user verify otp form appear on page send OTP "Nomor handphone ini telah terdaftar sebagai akun pencari kos di Mamikos"

  @TEST_SS-2970 @Automated @web-covered
  Scenario: [Web Tenant][Forgot Password - Phone Number]Error Message - Phone number is registered
    Given user go to mamikos homepage
    When user click on button masuk pencari kos
    And user click on lupa password?
    And user fill their registered phone number "086476512341"
    Then user verify on tenant page "Pilih Metode Verifikasi"

#  @forgotPasswordTenantInvalidOtp @TEST_SS-2964
#  Scenario: [Web Tenant][Forgot Password]Use Invalid OTP
#    Given user go to mamikos homepage
#    When user click on button masuk pencari kos
#    And user click on lupa password?
#    And user fill their registered phone number "081197878846"
#    And user waiting for "30" seconds for next step
#    And user choose verification by WA
#    And user input invalid code otp "1111"
#    Then user verify invalid OTP message "Kode verifikasi salah. Mohon masukkan kode verifikasi yang kami kirim."

#  @forgotPasswordTenantRegisterViaFacebook @TEST_SS-2965
#  Scenario: [Web Tenant][Forgot Password]Tenants (register via facebook) forget the password in tenant feature
#    Given user go to mamikos homepage
#    When user click on button masuk pencari kos
#    And user click on lupa password?
#    And user fill their registered phone number "081223102002"
#    And user choose verification by WA
#    Then user verify otp form appear on page send OTP "Nomor handphone ini telah terdaftar sebagai akun pencari kos di Mamikos"

  @forgotPasswordTenantUnregistered @TEST_SS-2996
  Scenario Outline: [Web Tenant][Forgot Password - Phone Number] Phone Number Error Compilation
    Given user go to mamikos homepage
    When user click on button masuk pencari kos
    And user click on lupa password?
    And user fill their unregistered phone number "<tenant phone number>"
    Then user get error message "<error message>"

    Examples:
      | tenant phone number | error message                                               |
      | 089220231001        | Masukkan nomor handphone yang terdaftar.                    |
      | 089212312304        | Nomor HP ini sudah digunakan untuk verifikasi di akun lain. |
      | 089876543217671     | Nomor handphone lebih dari 14 karakter.                     |
      | 081234              | Nomor handphone kurang dari 8 karakter.                     |
      | 1234567             | Nomor handphone harus diawali dengan 08                     |
      | 081abc212           | Nomor handphone hanya dapat diisi dengan angka              |
      | 085697344170        | Nomor HP tidak terdaftar sebagai pencari kos.               |

#  @resendOtpViaWhatsapp @TEST_COOP-5651
#  Scenario: [WEB][Tenant Forgot Password]Resend OTP via whatsapp
#    Given user go to mamikos homepage
#    When user click on button masuk pencari kos
#    And user click on lupa password?
#    And user fill their registered phone number "0892202305"
#    And user choose verification by WA
#    Then user verify "Kirim ulang kode" and click button resend OTP

  @resendOtpViaSms @TEST_SS-2969
  Scenario: [WEB][Tenant Forgot Password]Resend OTP via SMS
    Given user go to mamikos homepage
    When user click on button masuk pencari kos
    And user click on lupa password?
    And user fill their registered phone number "0892202305"
    And user choose verification by sms
    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_SS-2783
  Scenario: forgot password Tenant - Navigate To forgot password Page
    Given user go to mamikos homepage
    When user click on button masuk pencari kos
    And user click on lupa password?
    Then user redirected to "lupa-password-pencari"

  @TEST_SS-4294
  Scenario: Forgot Password Tenant - From Popular Area Page
    Given user navigate to popular area page
    When user click on enter button tenant in popular area page
    And user click on lupa password?
    And user fill their registered phone number "086476512341"
    Then user verify on tenant page "Pilih Metode Verifikasi"

  @TEST_SS-4295
  Scenario: Forgot Password Tenant - From Near Campus Page
    Given user navigate to near campus page
    When user click on enter button tenant in popular area page
    And user click on lupa password?
    And user fill their registered phone number "086476512341"
    Then user verify on tenant page "Pilih Metode Verifikasi"