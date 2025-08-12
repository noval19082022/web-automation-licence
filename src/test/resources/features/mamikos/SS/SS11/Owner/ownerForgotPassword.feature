@SS11
Feature: Owner - Forgot Password

#  @TEST_COOP-5180 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Use Invalid OTP
#    Given user go to mamikos homepage
#    When user want to change the owner password
#    And user fill their registered phone number "083843666868"
#    And user choose verification by WA
#    And user input invalid code otp "0000"
#    Then user verify invalid OTP message "Kode verifikasi salah. Mohon masukkan kode verifikasi yang kami kirim."

  @TEST_SS-2765 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Resend OTP via SMS
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "089120210101"
    And user choose verification by sms
    Then user verify "Kirim ulang kode" and click button resend OTP

#  @TEST_COOP-5187 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Resend OTP via WA
#    Given user go to mamikos homepage
#    When user want to change the owner password
#    And user fill their registered phone number "083843666868"
#    And user choose verification by WA
#    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_SS-2767 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Send OTP via sms
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by sms
    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui SMS."

  @TEST_SS-2768 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] User use number login via facebook on owner feature
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "085275574561"
    Then user get error message "Nomor HP tidak terdaftar sebagai pemilik kos."

  @TEST_SS-2769 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Input empty phone number
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "0855555555556"
    And user clear their unregistered phone number
    Then user see button choose verify method is disabled

  @TEST_SS-2770 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Use number not registered
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "08743333999"
    Then user get error message "Masukkan nomor handphone yang terdaftar."

  @TEST_SS-2771 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Wrong phone number format
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "09129299222"
    Then user get error message "Nomor handphone harus diawali dengan 08"

#  @TEST_COOP-5237 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Cancel verification page input OTP and ubah password
#    Given user go to mamikos homepage
#    When user want to change the owner password
#    And user fill their registered phone number "0891202102"
#    And user choose verification by WA
#    And user click back button on page otp
#    Then user see popup verifikasi batalkan proses "Yakin batalkan proses verifikasi?"

  @TEST_SS-2773 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number less than 8 characters
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "0812923"
    Then user get error message "Nomor handphone kurang dari 8 karakter."

  @TEST_SS-2774 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to SMS
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "081328787343"
    And user choose verification by sms
    And user click back button, batalkan
    And user choose verification by sms
    Then user see toast message "Mohon tunggu" "detik lagi untuk kirim ulang kode verifikasi." in forgot password

  @TEST_SS-2775 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number contains alphabet or symbol
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "aaaa@@@@"
    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"

  @TEST_SS-2776 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number is less than 8 char and contains alphabet/symbol
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "08912an"
    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"

#  @TEST_COOP-5242 @Automated @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Send OTP via WA
#    Given user go to mamikos homepage
#    When user want to change the owner password
#    And user fill their registered phone number "0891202103"
#    And user choose verification by WA
#    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui WhatsApp."

  @TEST_SS-2778 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Redirect to forgot password page
    Given user go to mamikos homepage
    When user want to change the owner password
    Then user redirected to "/lupa-password-pemilik"

  @TEST_SS-2779 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number is more than 14 char
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "089125555555555"
    Then user get error message "Nomor handphone lebih dari 14 karakter."

  @TEST_SS-2780 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Input registered phone number
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    Then user verify on page "Pilih Metode Verifikasi"

#  @TEST_COOP-5246 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to WA
#    Given user go to mamikos homepage
#    When user want to change the owner password
#    And user fill their registered phone number "081328787343"
#    And user choose verification by sms
#    And user click back button, batalkan
#    And user choose verification by WA
#    Then user verify otp form appear on page OTP "Verifikasi Nomor Handphone"

  @TEST_SS-2782 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] User direct to Whatsapp
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "085742883683"
    And user get error message "Nomor HP ini sudah digunakan untuk verifikasi di akun lain."
    When user click text "Mohon hubungi CS Mamikos."
    Then user directed to wa and verify pretext "Halo, nomor handphone/email saya 085742883683 sudah pernah digunakan untuk verifikasi di akun lain. Mohon bantuannya."

  @TEST_SS-2783
  Scenario: [WEB][Forgot Password][Owner] Navigate To forgot password Page
    Given user go to mamikos homepage
    When user want to change the owner password
    Then user redirected to "lupa-password-pemilik"

  @TEST_SS-4932
  Scenario: [WEB][Forgot Password][Owner] From Popular Area Page
    Given user navigate to popular area page
    When user click on enter button owner in popular area page
    And user click on lupa password?
    And user fill their registered phone number "083843666868"
    Then user verify on page "Pilih Metode Verifikasi"

  @TEST_SS-4931
  Scenario: [WEB][Forgot Password][Owner] From Near Campus Page
    Given user navigate to near campus page
    When user click on enter button owner in popular area page
    And user click on lupa password?
    And user fill their registered phone number "0891202104"
    Then user verify on page "Pilih Metode Verifikasi"