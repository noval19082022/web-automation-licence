@regression @LIMO3 @listing-monetization @ownerProfilePicture

Feature: Owner Profile Picture - Owner Setting

  @continue
  Scenario: Profile Picture is null
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | password   |
      | 083176408311 | qwerty123  |
    Then verify the profile picture is displayed

  @TEST_DOM-2286 @continue
  Scenario: [Setelan Akun] Email recommendation can be enabled and disabled
    When owner navigates to Akun menu
    And owner click on "checkmark  Rekomendasi via email"
    Then toast message "Rekomendasi via email berhasil dinonaktifkan" should be appear
    When owner click on "checkmark  Rekomendasi via email"
    Then toast message "Rekomendasi via email berhasil diaktifkan" should be appear

  @TEST_DOM-2287 @continue
  Scenario: [Setelan Akun] Chat notification can be enabled and disabled
    When owner navigates to Akun menu
    And owner click on "checkmark  Notifikasi via chat"
    Then toast message "Notifikasi via chat berhasil dinonaktifkan" should be appear
    When owner click on "checkmark  Notifikasi via chat"
    Then toast message "Notifikasi via chat berhasil diaktifkan" should be appear

  @TEST_DOM-2288
  Scenario: [Setelan Akun] SMS Update Kos can be enabled and disabled
    When owner navigates to Akun menu
    And owner click on "checkmark  Notifikasi kos via SMS"
    Then toast message "Notifikasi kos via SMS berhasil dinonaktifkan" should be appear
    When owner click on "checkmark  Notifikasi kos via SMS"
    Then toast message "Notifikasi kos via SMS berhasil diaktifkan" should be appear