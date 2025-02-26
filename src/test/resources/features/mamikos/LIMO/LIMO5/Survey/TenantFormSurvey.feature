@LIMO5
Feature: Tenant Form Survey Kost P2

  @TEST_LIMO-7129
  Scenario: [Survey][Form request] Create survey form request that contains information
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
    Then user will see that the text "Formulir survei kos" is displayed
    And user tap on edit profile on survey form
    And user edit profile name from survey form request "random"
    And user click on simpan profile btn
    Then user see pop up success save profile text
    Then user will see that the text "Formulir survei kos" is displayed

  @TEST_LIMO-7130
  Scenario: [Survey][Form request] The default for dates is always display today’s date
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
    Then user verify survey date on form is "today"

  @TEST_LIMO-7131
  Scenario: [Survey][Form request] Tenants can select a survey date up to 1 month from today's date.
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
    And user open survey date option on form survey
    And user tap on next month survey date on form survey
    Then user able to select date "15" on form survey
    Then user verify survey date on form is "15"

  @TEST_LIMO-7132
  Scenario: [Survey][Form request ] Tenant Cannot Select a Date Beyond 1 Month
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
    And user open survey date option on form survey
    Then user verify previous date is disable