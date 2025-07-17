@regression @LIMO3 @listing-monetization @ownerProfilePicture @DONEMIGRATINGTONEWBOARD

Feature: Owner Profile Picture - Owner Setting

  @continue @TEST_LIMO-802
  Scenario: [Setelan Akun][Profile Picture] Profile Picture is displayed
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password  |
      | 083176408311 | qwerty123 |
    Then verify the profile picture is displayed

  @TEST_LIMO-803 @continue
  Scenario: [Setelan Akun] Email recommendation can be enabled and disabled
    When owner navigates to Akun menu
    And owner uncheck on "Rekomendasi via email"
    Then toast message "Rekomendasi via email berhasil dinonaktifkan" should be appear
    When owner check on "Rekomendasi via email"
    Then toast message "Rekomendasi via email berhasil diaktifkan" should be appear

  @TEST_LIMO-800 @continue
  Scenario: [Setelan Akun] Chat notification can be enabled and disabled
    When owner navigates to Akun menu
    And owner uncheck on "Notifikasi via chat"
    Then toast message "Notifikasi via chat berhasil dinonaktifkan" should be appear
    When owner check on "Notifikasi via chat"
    Then toast message "Notifikasi via chat berhasil diaktifkan" should be appear

  @TEST_LIMO-801
  Scenario: [Setelan Akun] SMS Update Kos can be enabled and disabled
    When owner navigates to Akun menu
    And owner uncheck on "Notifikasi kos via SMS"
    Then toast message "Notifikasi kos via SMS berhasil dinonaktifkan" should be appear
    When owner check on "Notifikasi kos via SMS"
    Then toast message "Notifikasi kos via SMS berhasil diaktifkan" should be appear