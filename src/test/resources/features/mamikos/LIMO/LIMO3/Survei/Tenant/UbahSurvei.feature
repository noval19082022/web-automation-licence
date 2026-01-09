@LIMO3 @tenantSurveyP2 @ubahSurvey
Feature: Ubah Survei

  @TEST_LIMO-7151 @TEST_LIMO-7281
  Scenario: Chatroom Reschedule survey request
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0811978788415 | 087708777615 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
  #  And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
      # This survey feature is revamp on 29/09/25

#    And user open time survey option on form survey
#    Then user select survey available time
#    And user check on toggle button orang lain yang akan datang survei
#    Then user will see that the text "Tidak boleh kosong." is displayed
#    And user fill nama for orang lain yang akan datang survey with value "pmo"
#    And user fill hubungan for orang lain yang akan datang survey with value "ook"
#    Then user verify ajukan survey btn is enable on survey form
#    And user click "Ajukan Survei" button
#
#  @TEST_LIMO-7283 @TEST_LIMO-7284 @continue
#  Scenario: Reschedule survey from tomorrow to today
#    And user click "Ubah Survei" button
#    And user open time survey option on form survey
#    Then user select survey available time
#    And user click "Kirim" button
#
#  @TEST_LIMO-7285
#  Scenario: Verify toast and chat bubble after rescheduling
#    Then toast message "Waktu survei berhasil diubah." should be appear
#    Then chat room appear with latest message "Survei Diubah"
#
##    Scenario wajib setelah pengajuan survei (Cancel survei)
#  Scenario: Cancel Survei kost
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag    | phone prod   | password  |
#      | 0811978788415 | 087708777615 | qwerty123 |
#    And tenant search kost then go to kost details:
#      | kost name stag              | kost name prod              |
#      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
#    And user dismiss FTUE booking benefit
#    And user click chat in kos detail
#    And user click on chevron detail survei
#    And user click on "Batalkan" button
#    And user fill form reason cancel survei "Saya ingin membatalkan ajukan survei"
#    And user click on "Kirim" button
#    Then toast message "Survei berhasil dibatalkan." should be appear