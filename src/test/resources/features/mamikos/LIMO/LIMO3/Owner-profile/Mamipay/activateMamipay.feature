@regression @LIMO3 @listing-monetization @activateMamipay

Feature: Activate Mamipay

  @invalidBankAccountNumber @continue @TEST_LIMO-5673
  Scenario: Invalid input bank account number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670001 | qwerty123 |
    And owner navigates to "/kos/booking/register"
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    Then verify nama lengkap equals username owner
    When owner input on "nomor rekening Anda" ""
    Then user should see the message "Nomor rekening tidak boleh kosong." displayed under text field
    When owner input on "nomor rekening Anda" "QWERTY"
    Then user should see the message "Hanya diisi dengan angka" displayed under text field
    When owner input on "nomor rekening Anda" "123"
    Then user should see the message "Minimal 5 Karakter" displayed under text field
    When owner input on "nomor rekening Anda" "09182928329"

  @invalidBankName @continue @TEST_LIMO-5674
  Scenario: Invalid bank name
    And owner input on "nama bank" ""
    Then user should see the message "Nama bank harus dipilih" displayed under text field
    When owner input on "nama bank" "ABC"
    Then user should see the message "Nama Bank tidak ditemukan" displayed under text field
    When owner input on "nama bank" "BCA"
    And owner select bank name "BCA"

  @invalidBankAccountName @continue
  Scenario: Invalid bank account name
    And owner input on "nama pemilik rekening" ""
    Then user should see the message "Nama pemilik rekening tidak boleh kosong." displayed under text field
    When owner input on "nama pemilik rekening" "Yu"
    Then user should see the message "Minimal 3 Karakter" displayed under text field
    When owner input on "nama pemilik rekening" "tiara"

  @invalidName @continue
  Scenario: Invalid name
    And owner input on "nama lengkap" ""
    Then user should see the message "Nama lengkap tidak boleh kosong." displayed under text field
    When owner input on "nama lengkap" "Yu"
    Then user should see the message "Minimal 3 Karakter" displayed under text field
    And verify mamipay form information:
    """
    Pastikan data Anda benar dan sesuai, agar uang pembayaran kos dapat
          ditransfer dengan lancar.
    """
   And verify kirim data button is disable

  @submitInputFormDataDiri @TEST_LIMO-5674
  Scenario: Valid input form data diri
    When owner input on "nama lengkap" "tiara"
    Then verify kirim data button is disable
    When owner check term and condition
    And owner set active page to 0
    And owner click term and condition
    And owner click "Kirim Data" button
    Then user see success add data kos pop up with text "Permintaan Aktivasi Dikirimkan"
    And owner click "Kembali" button