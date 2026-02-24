@regression @essentialTest2 @SS16 @mantool

Feature: Forgot password mantool

  @TEST_SS-910 @continue
  Scenario: Input invalid phone number
    Given user navigate to mantool
    And user visit forgot password mantool
    When user input phone number "abcdefghijklmnopqrstuvwxyz"
    Then field no handphone can only accept number
    And button verifikasi is "disable"

  @TEST_SS-934 @continue
  Scenario: Input owner phone number that not registered as Agen
    When user input phone number "085947715987"
    Then button verifikasi is "enable"
    When user click button verifikasi forgot password mantool
    Then show forgot password error message "Masukkan nomor handphone yang terdaftar."

  @TEST_SS-935
  Scenario: Input valid agen phone number
    When user input phone number "081223334444"
    When user click button verifikasi forgot password mantool
    Then user redirect to request otp method page