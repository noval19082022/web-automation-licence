@regression @LIMO6 @pengajuanSurveiCounterUpdate @WEB @AUTOMATED
Feature: Pengajuan Survei Counter Badge Update on Owner Dashboard

  Scenario: Submit survei hari ini from chat template on Kost Detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod | password  |
      | 0892202601  | 0812000005 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Yang Terdalam Pasar Kemis Tangerang"
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Survei Hari ini"
    Then user verify survey date on form is "today"
    And user select survey time period "Sore"
    And user select survey time "17:00"
    And user fill phone number "0811978788416" on survey form
    And user check TnC agreement checkbox on survey form
    And user tap on ajukan survey btn on form
    And user confirm popup ajukan survey if appear
    And user go to mamikos homepage

  @TEST_LIMO-10553
  Scenario: [Owner Dashboard][Pengajuan Survei] Counter badge updates after accepting a survey request
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag  | phone prod    | password  |
      | 0891202527  | 0812345670001 | qwerty123 |
    And owner navigates to owner dashboard
    And I have 2 pending survey requests
    And I am on the chat list survey page
    When owner non gp dismiss FTUE chatroom
    And search chat in chatlist "Noval New"
    And user dismiss FTUE TBC
    And owner accept survey
    And owner navigates to owner dashboard
    And I check the Pengajuan Survei icon
    Then the counter should now display "1"
    And the counter should reflect the updated count immediately
