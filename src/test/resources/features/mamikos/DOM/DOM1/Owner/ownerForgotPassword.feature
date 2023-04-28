@DOM1
Feature: Owner - Forgot Password

  @TEST_DOM-2221 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Resend OTP via SMS
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by sms
    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_DOM-2222 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Resend OTP via WA
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    And user choose verification by WA
    Then user verify "Kirim ulang kode" and click button resend OTP

  @TEST_DOM-2223 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Redirect to forgot password page
    Given user go to mamikos homepage
    When user want to change the owner password
    Then user redirected to "/lupa-password-pemilik"

  @TEST_DOM-2224 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Input registered phone number
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their registered phone number "083843666868"
    Then user verify on page "Pilih Metode Verifikasi"

  @TEST_DOM-2225 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Use number not registered
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "08743333999"
    Then user get error message "Masukkan nomor handphone yang terdaftar."

  @TEST_DOM-2226 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Wrong phone number format
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "09129299222"
    Then user get error message "Nomor handphone harus diawali dengan 08"

  @TEST_DOM-2227 @Automated @DOM @web-covered
  Scenario: [WEB][Forgot Password][Owner] Phone number less than 8 characters
    Given user go to mamikos homepage
    When user want to change the owner password
    And user fill their unregistered phone number "0812923"
    Then user get error message "Nomor handphone kurang dari 8 karakter."
#
#  @TEST_DOM-2228 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Phone number contains alphabet or symbol
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "aaaa@@@@"
#    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"
#
#  @TEST_DOM-2229 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Phone number is less than 8 char and contains alphabet/symbol
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "08912an"
#    Then user get error message "Nomor handphone hanya dapat diisi dengan angka"
#
#  @TEST_DOM-2230 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Phone number is more than 14 char
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "089125555555555"
#    Then user get error message "Nomor handphone lebih dari 14 karakter."
#
#  @TEST_DOM-2231 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Input empty phone number
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "0855555555556"
#    And user fill their unregistered phone number ""
#    Then user see button choose verify method is disabled
#
#  @TEST_DOM-2232 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Send OTP via WA
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "083843666868" and click send button
#    And user click otp via wa on page "Pilih Metode Verifikasi"
#    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui WhatsApp."
#
#  @TEST_DOM-2233 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Send OTP via sms
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "083843666868" and click send button
#    And user click otp via sms on page "Pilih Metode Verifikasi"
#    Then user verify otp form appear on page send OTP "Mohon isi kolom berikut dengan kode verifikasi yang kami kirimkan ke ********6868 melalui SMS."
#
#  @TEST_DOM-2234 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] User use number login via facebook on owner feature
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "085275574561"
#    Then user get error message "Nomor HP tidak terdaftar sebagai pemilik kos."
#
#  @TEST_DOM-2235 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Use Invalid OTP
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "083843666868" and click send button
#    And user click otp via wa on page "Pilih Metode Verifikasi"
#    And user input invalid code otp "0000"
#    Then user verify invalid OTP message "Kode verifikasi salah." "Mohon masukkan kode verifikasi yang kami kirim."
#
#  @TEST_DOM-2236 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Cancel verification page input OTP and ubah password
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "083843666868" and click send button
#    And user click otp via sms on page "Pilih Metode Verifikasi"
#    And user click back button on page otp
#    Then user see popup verifikasi batalkan proses "Yakin batalkan proses verifikasi?"
#
#  @TEST_DOM-2237 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to SMS
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "085941399178" and click send button
#    And user click otp via sms on page "Pilih Metode Verifikasi"
#    And user click back button on page otp
#    And user click ya, batalkan
#    And user click otp via sms on page "Pilih Metode Verifikasi"
#    Then user see toast message "Mohon tunggu" "detik lagi untuk kirim ulang kode verifikasi." in forgot password
#
#  @TEST_DOM-2238 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] Cancel verification and change metode OTP SMS to WA
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their registered phone number "083843666868" and click send button
#    And user click otp via sms on page "Pilih Metode Verifikasi"
#    And user click back button on page otp
#    And user click ya, batalkan
#    And user click otp via wa on page "Pilih Metode Verifikasi"
#    Then user verify otp form appear on page OTP "Verifikasi Nomor Handphone"
#
#  @TEST_DOM-2239 @Automated @DOM @web-covered
#  Scenario: [WEB][Forgot Password][Owner] User direct to Whatsapp
#    Given user navigates to "mamikos /"
#    When user clicks on Enter button
#    And user click login with owner and click forgot password button
#    And user fill their unregistered phone number "085742883683"
#    And user get error message "Nomor HP ini sudah digunakan untuk verifikasi di akun lain."
#    When user click underline "Mohon hubungi CS Mamikos."
#    Then user directed to wa and verify pretext "Halo, nomor handphone/email saya 085742883683 sudah pernah digunakan untuk verifikasi di akun lain. Mohon bantuannya."
