@regression @pman3 @pman-prod @mantool @agent-registration

  Feature: Agent Registration

    @TEST_SS-987 @continue
    Scenario: User doesn't upload KTP photo
      Given admin navigate to mantool
      And user daftar agen
      When agen not upload photo KTP
      Then show agen registration error message "Upload foto KTP Anda."

    @TEST_SS-996 @continue
    Scenario: User upload KTP photo with file size more than 2MB
      When agen upload KTP using file "more than 2MB"
      Then show agen registration error message upload ktp "File tidak dikenali atau melebihi 2 MB"

    @TEST_SS-994 @continue
    Scenario: User upload KTP photo with file size less than 2MB
      When agen upload KTP using file "less than 2MB"
      Then no agen registration error message foto ktp

    @TEST_SS-995 @continue
    Scenario: User inputs invalid age range
      #below 18 tahun
      When agen input age "17"
      Then show agen registration error message "Minimal 18 tahun dan maksimal 54 tahun."
      #above 54 tahun
      When agen input age "55"
      Then show agen registration error message "Minimal 18 tahun dan maksimal 54 tahun."

    @TEST_SS-972 @continue
    Scenario: User inputs valid age range
      #between 18 - 54 tahun
      When agen input age "25"
      Then no agen registration error message
      #exact 18 tahun
      When agen input age "18"
      Then no agen registration error message
      #exact 54 tahun
      When agen input age "54"
      Then no agen registration error message

    @TEST_SS-986 @continue
    Scenario: User Inputs KTP number Less Than 16 Digits
      When agen input ktp "340209129039000"
      Then show agen registration error message "Masukkan 16 karakter nomor KTP Anda."

    @TEST_SS-985 @continue
    Scenario: User Inputs KTP number More Than 16 Digits
      When agen input ktp "34020912903900005"
      Then show agen registration error message "Masukkan 16 karakter nomor KTP Anda."

    @TEST_SS-988 @continue
    Scenario:User Inputs 16 Digits KTP number
      When agen input ktp "3402091290390000"
      Then no agen registration error message

    @TEST_SS-974 @continue
    Scenario: User Inputs password less than 8 character
      When agen input password "asdf"
      Then show agen registration error message "Password harus berisi min. 8 karakter, kombinasi angka (0-9) dan huruf alfabet (A-Z)."

    @TEST_SS-976 @continue
    Scenario: User Inputs Password more than 25 character
      When agen input password "MHPHZIXNQIG13Y9C2GV4T1DZCa"
      Then show agen registration error message "Password lebih dari 25 karakter."

    @TEST_SS-967 @continue
    Scenario: User Inputs valid password
      When agen input password "qwerty123"
      Then no agen registration error message

    @TEST_SS-970 @continue
    Scenario: User doesn't fill password
      When agen input password ""
      Then show agen registration error message "Masukkan Password Anda."

    @TEST_SS-968
    Scenario: User Inputs different Password in the Confirmation Password Field
      When agen input password "qwerty123"
      And agen input confirmation password "asdf1234"
      Then show agen registration error message "Masukkan sesuai dengan Password Baru."