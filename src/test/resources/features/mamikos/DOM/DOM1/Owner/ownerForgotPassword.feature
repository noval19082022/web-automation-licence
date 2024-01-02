@DOM1
Feature: Owner - Forgot Password

  @TEST_COOP-5180 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Use Invalid OTP
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by WA
    And user input invalid code otp "0000"
    Then user verify invalid OTP message "Kode verifikasi salah. Mohon masukkan kode verifikasi yang kami kirim."

  @TEST_COOP-5182 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Resend OTP via SMS
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by sms
    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_COOP-5187 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Resend OTP via WA
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by WA
    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_COOP-5232 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Send OTP via sms
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by sms
    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui SMS."

  @TEST_COOP-5233 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] User use number login via facebook on owner feature
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "085275574561"
    Then user get error message "Nomor HP tidak terdaftar sebagai pemilik kos."

  @TEST_COOP-5234 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Input empty phone number
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "0855555555556"
    And user clear their unregistered phone number
    Then user see button choose verify method is disabled

  @TEST_COOP-5235 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Use number not registered
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "08743333999"
    Then user get error message "Masukkan nomor handphone yang terdaftar."

  @TEST_COOP-5236 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Wrong phone number format
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "09129299222"
    Then user get error message "Nomor handphone harus diawali dengan 08"

  @TEST_COOP-5237 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Cancel verification page input OTP and ubah password
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by WA
    And user click back button on page otp
    Then user see popup verifikasi batalkan proses "Yakin batalkan proses verifikasi?"

  @TEST_COOP-5238 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number less than 8 characters
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "0812923"
    Then user get error message "Nomor handphone kurang dari 8 karakter."

  @TEST_COOP-5239 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to SMS
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "081328787342"
    And user choose verification by sms
    And user click back button, batalkan
    And user choose verification by sms
    Then user see toast message "Mohon tunggu" "detik lagi untuk kirim ulang kode verifikasi." in forgot password

  @TEST_COOP-5240 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number contains alphabet or symbol
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "aaaa@@@@"
    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"

  @TEST_COOP-5241 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number is less than 8 char and contains alphabet/symbol
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "08912an"
    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"

  @TEST_COOP-5242 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Send OTP via WA
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by WA
    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui WhatsApp."

  @TEST_COOP-5243 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Redirect to forgot password page
    Given user go to mamikos homepage
    When user want to change the owner password
    Then user redirected to "/lupa-password-pemilik"

  @TEST_COOP-5244 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number is more than 14 char
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "089125555555555"
    Then user get error message "Nomor handphone lebih dari 14 karakter."

  @TEST_COOP-5245 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Input registered phone number
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    Then user verify on page "Pilih Metode Verifikasi"

  @TEST_COOP-5246 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to WA
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "081328787342"
    And user choose verification by sms
    And user click back button, batalkan
    And user choose verification by WA
    Then user verify otp form appear on page OTP "Verifikasi Nomor Handphone"

  @TEST_COOP-5247 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] User direct to Whatsapp
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "085742883683"
    And user get error message "Nomor HP ini sudah digunakan untuk verifikasi di akun lain."
    When user click text "Mohon hubungi CS Mamikos."
    Then user directed to wa and verify pretext "Halo, nomor handphone/email saya 085742883683 sudah pernah digunakan untuk verifikasi di akun lain. Mohon bantuannya."