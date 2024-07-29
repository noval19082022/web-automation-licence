@regression @pman3 @mantool

  Feature: Agent Registration

    @TEST_SS-987 @continue
    Scenario: User doesn't upload KTP photo
      Given admin navigate to mantool
      And user daftar agen
      When agen not upload photo KTP
      Then show agen registration error message foto ktp "empty KTP"

    @TEST_SS-996 @continue
    Scenario: User upload KTP photo with file size more than 2MB
      When agen upload KTP using file "more than 2MB"
      Then show agen registration error message foto ktp "oversize KTP"


    @TEST_SS-994
    Scenario: User upload KTP photo with file size less than 2MB
      When agen upload KTP using file "less than 2MB"
      Then no agen registration error message foto ktp

    @TEST_SS-995 @continue
    Scenario: User inputs invalid age range
      Given admin navigate to mantool
      And user daftar agen
      #below 18 tahun
      When agen input age "17"
      Then show agen registration error message Usia "Minimal 18 tahun dan maksimal 54 tahun."
      #above 54 tahun
      When agen input age "55"
      Then show agen registration error message Usia "Minimal 18 tahun dan maksimal 54 tahun."

    @TEST_SS-972
    Scenario: User inputs valid age range
      #between 18 - 54 tahun
      When agen input age "25"
      Then no agen registration error message usia
      #exact 18 tahun
      When agen input age "25"
      Then no agen registration error message usia
      #exact 54 tahun
      When agen input age "54"
      Then no agen registration error message usia

    @TEST_SS-986 @continue
    Scenario: User Inputs KTP number Less Than 16 Digits
      Given admin navigate to mantool
      And user daftar agen
      When agen input ktp "340209129039000"
      Then show agen registration error message ktp "Masukkan 16 karakter nomor KTP Anda."

    @TEST_SS-85
    Scenario: User Inputs KTP number More Than 16 Digits
      When agen input ktp "34020912903900005"
      Then show agen registration error message ktp "Masukkan 16 karakter nomor KTP Anda."

    @TEST_SS-988
    Scenario:User Inputs 16 Digits KTP number
      When agen input ktp "3402091290390000"
      Then no agen registration error message ktp