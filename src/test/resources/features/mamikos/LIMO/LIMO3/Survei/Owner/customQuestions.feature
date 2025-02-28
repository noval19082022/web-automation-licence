@regression @LIMO3
Feature: Survei - custom questions

  @TEST_LIMO-7653
  Scenario: Entry Point "Pengaturan Survei" redirect to Correct Page
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202413 | 087880495933 | qwerty123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user click on filter survei kos
    And user click on pengaturan survei kos
    And user click on tambah button
    And user fills first questions "Saya ingin kos disini"
    And user click on simpan pengaturan button
    Then toast message "Pengaturan berhasil disimpan" should be appear

  @TEST_LIMO-7679
  Scenario: GP 2 owners can add max 3 questions custom questions
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 087880495933 | qwerty123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user click on filter survei kos
    And user click on pengaturan survei kos
    And user click on tambah button 3 times
    Then User see "3" questions appear

  @TEST_LIMO-7681
  Scenario: Create 3 questions then delete question number 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 087880495933 | qwerty123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user click on filter survei kos
    And user click on pengaturan survei kos
    And user click on tambah button 3 times
    And user delete questions 0
    Then User see "2" questions appear

  @TEST_LIMO-7682
  Scenario: Create 3 questions then delete question number 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 087880495933 | qwerty123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user click on filter survei kos
    And user click on pengaturan survei kos
    And user click on tambah button 3 times
    And user delete questions 1
    Then User see "2" questions appear

  @TEST_LIMO-7683
  Scenario: Create 3 questions then delete question number 1
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod   | password  |
      | 0891202415 | 087880495933 | qwerty123 |
    And user click chat button in top bar owner home page
    And user dismiss FTUE MARS Goldplus and FTUE Broadcast
    And user click on filter survei kos
    And user click on pengaturan survei kos
    And user click on tambah button 3 times
    And user delete questions 2
    Then User see "2" questions appear
