@LIMO3 @tenantSurveyP2
Feature: Ubah Survei

  @TEST_LIMO-7151
Scenario: Chatroom Reschedule survey request
    Given user go to mamikos homepage
    When user login as tenant via phone number:
    | phone stag    | phone prod   | password  |
    | 0811978788415 | 087708777615 | qwerty123 |
    And tenant search kost then go to kost details:
    | kost name stag              | kost name prod              |
    | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user open time survey option on form survey
    Then user select survey available time
    And user check on toggle button orang lain yang akan datang survei
    Then user will see that the text "Tidak boleh kosong." is displayed
    And user fill nama for orang lain yang akan datang survey with value "pmo"
    And user fill hubungan for orang lain yang akan datang survey with value "ook"
    Then user verify ajukan survey btn is enable on survey form
    And user click "Ajukan Survei" button
    And user click "Ubah Survei" button
    And user select date "tomorrow" survei
    And user open time survey option on form survey
    Then user select survey available time
    And user click "Kirim" button
    Then toast message "Waktu survei berhasil diubah." should be appear
    Then chat room appear with latest message "Survei Diubah"

