@LIMO5 @tenantSurveyP2
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

#  https://mamiteam-qa3.atlassian.net/browse/LIMO-7133
  @TEST_LIMO-7133
  Scenario: [Survey][Form request] Dropdown Shows Available Times
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
    Then user verify available time is higher than current time
#    Then user see the following time options:
#  08:00, 08:30, 09:00, 09:30, 10:00,
#  10:30, 11:00, 11:30, 12:00, 12:30,
#  13:00, 13:30, 14:00, 14:30, 15:00,
#  15:30, 16:00, 16:30, 17:00, 17:30,
#  18:00, 18:30, 19:00.

  @TEST_LIMO-7134
  Scenario: [Survey][Form request] Tenant Can Select a Specific Time
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

  @TEST_LIMO-7135
  Scenario: [Survey][Form request] Validation Error for Missing Fields
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0811978788412 | 087708777612 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    Then user will see that the text "Mohon lengkapi data profilmu sebelum mengajukan survei." is displayed

  @TEST_LIMO-7137
  Scenario: [Survey][Form request] No Time Available When Tenant Submits Survey if more than 19:00 today
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
    Then user see there is no available survey time for today if open more than 19:00

  @TEST_LIMO-7138
  Scenario: [Survey][Form request] Data Validation must be the same between User Profile Form and Survey Form
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
    Then user will see that the text "Data yang Akan Survei Kos" is displayed
    Then user see the gender on survey form is "Laki-laki"
    Then user will see that the text "Mahasiswa" is displayed

  @TEST_LIMO-7139
  Scenario: [Survey][Form request] Verify the system real-time validation after profile data is updated.
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

  @TEST_LIMO-7140
  Scenario: [Survey][Form request] Profile Data is Incomplete
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0811978788412 | 087708777612 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    Then user will see that the text "Mohon lengkapi data profilmu sebelum mengajukan survei." is displayed
    Then user verify ajukan survey btn is disable on survey form

  @TEST_LIMO-7141
  Scenario: [Survey][Form request] Profile Data is Complete
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
    Then user verify ajukan survey btn is enable on survey form

  @TEST_LIMO-7142
  Scenario: [Survey][Form request] Error Text Appears When Mandatory Data profile user is not yet fill
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0811978788412 | 087708777612 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user open time survey option on form survey
    Then user select survey available time
    Then user will see that the text "Mohon lengkapi data profilmu sebelum mengajukan survei." is displayed

  @TEST_LIMO-7143
  Scenario: [Survey][Form request] System Prevents Form Submission If Error Text Exists
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod   | password  |
      | 0811978788412 | 087708777612 | qwerty123 |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost bringas Ngaglik Sleman | Kost bringas Ngaglik Sleman |
    And user dismiss FTUE booking benefit
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user open time survey option on form survey
    Then user select survey available time
    Then user will see that the text "Mohon lengkapi data profilmu sebelum mengajukan survei." is displayed
    Then user verify ajukan survey btn is disable on survey form