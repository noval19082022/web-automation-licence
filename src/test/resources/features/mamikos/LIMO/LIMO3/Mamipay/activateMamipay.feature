@regression @LIMO3 @listing-monetization @activateMamipay @DONEMIGRATINGTONEWBOARD

Feature: Activate Mamipay


  @invalidBankAccountNumber @continue @TEST_LIMO-3682
  Scenario: Invalid input bank account number
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag    | password  |
      | 0812345670001 | qwerty123 |
    And owner navigates to "/kos/booking/register"
    Then verify the title on mamipay owner onboarding displayed
    When owner click Lanjutkan button
    Then verify nama lengkap equals username owner
    When owner input on "Masukkan nomor rekening" ""
    Then user should see the message "Nomor rekening tidak boleh kosong." displayed under text field
    When owner input on "Masukkan nomor rekening" "QWERTY"
    Then user should see the message "Hanya diisi dengan angka" displayed under text field
    When owner input on "Masukkan nomor rekening" "123"
    Then user should see the message "Minimal 5 Karakter" displayed under text field
    When owner input on "Masukkan nomor rekening" "09182928329"

  @invalidBankName @continue @TEST_LIMO-3683
  Scenario: Invalid bank name
    And owner input on "Pilih nama bank" ""
    Then user should see the message "Nama bank harus dipilih" displayed under text field
    When owner input on "Pilih nama bank" "ABC"
    Then user should see the message "Nama Bank tidak ditemukan" displayed under text field
    When owner input on "Pilih nama bank" "BCA"
    And owner select bank name "BCA"

  @invalidBankAccountName @continue @TEST_LIMO-3684
  Scenario: Invalid bank account name
    And owner input on "nama pemilik rekening" ""
    Then user should see the message "Nama pemilik rekening tidak boleh kosong." displayed under text field
    When owner input on "nama pemilik rekening" "Yu"
    Then user should see the message "Minimal 3 Karakter" displayed under text field
    When owner input on "nama pemilik rekening" "tiara"

  @invalidName @continue @TEST_LIMO-3685
  Scenario: Invalid name
    And owner input on "Masukkan nama lengkap Anda sesuai KTP" ""
    Then user should see the message "Nama lengkap tidak boleh kosong." displayed under text field
    When owner input on "Masukkan nama lengkap Anda sesuai KTP" "Yu"
    Then user should see the message "Minimal 3 Karakter" displayed under text field
    And verify mamipay form information:
    """
    Pastikan data benar agar uang pembayaran sewa kos dapat ditransfer
          dengan lancar.
    """
    And verify kirim data button is disable

  @submitInputFormDataDiri @TEST_LIMO-3686
  Scenario: Valid input form data diri
    When owner input on "Masukkan nama lengkap Anda sesuai KTP" "tiara"
    Given verify kirim data button is disable
    When owner check term and condition
    And owner close page number 1
    And owner set active page to 0
    And owner click "Kirim Data" button
    Then user see success add data kos pop up with text "Permintaan Aktivasi Dikirimkan"
    And owner click "Kembali" button