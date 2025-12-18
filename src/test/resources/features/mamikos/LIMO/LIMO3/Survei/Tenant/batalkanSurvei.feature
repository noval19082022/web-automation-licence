@LIMO3 @cancelSurveiSurveyP2
Feature: Batalkan survei P2

  @TEST_LIMO-7289
  Scenario: Cancel survey request with a valid reason
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag | phone prod   | password  |
      | 0892202413 | 087708777615 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
#    And user dismiss FTUE booking benefit
    And user click chat in kos detail

      # This survey feature is revamp on 29/09/25
#    And user tap on survey kost btn on detail chatroom
#    And user open time survey option on form survey
#    Then user select survey available time
#    And user click on "Ajukan Survei" button
#    And user click on chevron detail survei
#    And user click on "Batalkan" button
#    And user fill form reason cancel survei "Saya ingin membatalkan ajukan survei"
#    And user click on "Kirim" button
#    Then toast message "Survei berhasil dibatalkan." should be appear
#   # And chat room appear with latest message "Survei Dibatalkan Alasan:Saya ingin membatalkan ajukan survei"
#
#  @TEST_LIMO-7290
#  Scenario: Attempt to cancel a survey request without providing a reason
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag | phone prod   | password  |
#      | 0892202413 | 087708777615 | qwerty123 |
#    And tenant search kost then go to kost details:
#      | kost name stag              | kost name prod              |
#      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
#    And user dismiss FTUE booking benefit
#    And user click chat in kos detail
#    And user tap on survey kost btn on detail chatroom
#    And user open time survey option on form survey
#    Then user select survey available time
#    And user click on "Ajukan Survei" button
#    And user click on chevron detail survei
#    And user click on "Batalkan" button
#    And user fill form reason cancel survei ""
#    And user click on "Kirim" button
#    Then error message on "Wajib diisi minimal 25 karakter." field is displayed
#
#  @TEST_LIMO-7291
#  Scenario: Attempt to reassign survey after cancellation
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag | phone prod   | password  |
#      | 0892202413 | 087708777615 | qwerty123 |
#    And tenant search kost then go to kost details:
#      | kost name stag              | kost name prod              |
#      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
#    And user dismiss FTUE booking benefit
#    And user click chat in kos detail
#    And user tap on survey kost btn on detail chatroom
#    And user open time survey option on form survey
#    Then user select survey available time
#    And user click on "Ajukan Survei" button
#    And user click on chevron detail survei
#    And user click on "Batalkan" button
#    And user fill form reason cancel survei "Saya ingin membatalkan ajukan survei"
#    And user click on "Kirim" button
#    Then toast message "Survei berhasil dibatalkan." should be appear
#    And user tap on survey kost btn on detail chatroom
#    And user open time survey option on form survey
#    Then user select survey available time
#    And user click on "Ajukan Survei" button
#    And user click on chevron detail survei
#    And user click on "Batalkan" button
#    And user fill form reason cancel survei "Saya ingin membatalkan ajukan survei"
#    And user click on "Kirim" button