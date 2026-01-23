@regression @samedaySurveyTenant @LIMO6
Feature: Sameday Survey Tenant

  @TEST_LIMO-9392 @TEST_LIMO-10277 @TEST_LIMO-10278
  Scenario Outline: [Survey][Tenant] Display date options based on owner sameday survey status <owner_type> with sameday status <sameday_status>
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag | kost name prod |
      | <kost_name>    | <kost_name>    |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    Then user verify survey date type "Survei Hari Ini" is "<hari_ini_status>"
    And user verify survey date type "Survei Hari Ini" clickable is "<hari_ini_clickable>"
    And user verify survey date type "Tanggal Lain" is visible
    And user verify survey date type "Tanggal Lain" clickable is "Yes"
    Examples:
      | kost_name                     | owner_type | sameday_status | hari_ini_status    | hari_ini_clickable |
      | Kost Apik Desta Tipe A Tamvan | P1         | active         | Visible            | Yes                |
      | Kost P2 With Sameday Active   | P2         | active         | Visible            | Yes                |
      | Kost P2 With Sameday Inactive | P2         | inactive       | Visible (disabled) | No                 |

  @TEST_LIMO-9393
  Scenario: [Survey][Tenant] Select "Survei Hari Ini" that enabled by owner
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                |
      | Kost Apik Desta Tipe A Tamvan | Kost Apik Desta Tipe A Tamvan |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Survei Hari ini"
    Then user verify survey date on form is "today"
    And user verify sameday survey message is visible
    And user verify only today is enabled in calendar

  @TEST_LIMO-9394
  Scenario: [Survey][Tenant] Select "Tanggal Lain" option
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                |
      | Kost Apik Desta Tipe A Tamvan | Kost Apik Desta Tipe A Tamvan |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Tanggal Lain"
    Then user verify survey date picker placeholder is "Pilih Tanggal"
    And user will see that the text "Survei dianjurkan di akhir pekan agar pemilik dapat bersiap" is displayed
    And user open survey date picker on form survey
    And user verify date range is selectable up to "30" days from today
    And user verify past dates are disabled

  @TEST_LIMO-9395
  Scenario: [Survey][Tenant] Attempt to select sameday for ineligible/Disabled P2 owner
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                |
      | Kost P2 With Sameday Inactive | Kost P2 With Sameday Inactive |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    Then user verify survey date type "Survei Hari Ini" is visible
    And user verify survey date type "Survei Hari Ini" is disabled
    And user verify survey date type "Survei Hari Ini" is grayed out
    And user verify survey date type "Survei Hari Ini" is not clickable
#    And user verify survey date type "Survei Hari Ini" shows tooltip with unavailable message

  @TEST_LIMO-9410
  Scenario: [Survey][Tenant] P2 time slot availability with 3-hour rule
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost P2 With Sameday Active | Kost P2 With Sameday Active |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Survei Hari ini"
    Then user verify time slot availability for P2 with 3-hour rule:
      | time_period | time_slot |
      | Pagi        | 08:00     |
      | Siang       | 12:00     |
      | Sore        | 15:00     |
      | Sore        | 19:00     |

  @TEST_LIMO-9411
  Scenario: [Survey][Tenant] P1 time slot availability without 3-hour restriction
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                |
      | Kost Apik Desta Tipe A Tamvan | Kost Apik Desta Tipe A Tamvan |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Survei Hari ini"
    Then user verify time slot availability for P1 without 3-hour rule:
      | time_period | time_slot |
      | Pagi        | 08:00     |
      | Siang       | 12:00     |
      | Sore        | 15:00     |
      | Sore        | 19:00     |

  @TEST_LIMO-9412
  Scenario: [Survey][Tenant] All time slots exhausted for sameday or unselectable if tenant request survey more than trace hold
#  // For P2: all slots exhausted trace hold if current time + 3 hours > 19:00
#  // For P1: all slots exhausted trace hold if current time > 19:00
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost P2 With Sameday Active | Kost P2 With Sameday Active |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Survei Hari ini"
    Then user verify all time slots are disabled for survey
    And user verify "Survei Hari Ini" option becomes unselectable survey
    And user verify system suggests "Tanggal Lain" option survey

@TEST_LIMO-9413
  Scenario: [Survey][Tenant] Time category interaction
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag                | kost name prod                |
      | Kost Apik Desta Tipe A Tamvan | Kost Apik Desta Tipe A Tamvan |
    And user dismiss FTUE booking benefit
  And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Tanggal Lain"
    And user open survey date picker on form survey
    And user select date "available" on survey form
    When user select survey time period "Siang"
    Then user verify only time slots for period "Siang" are displayed
    And user verify displayed time slots are between "11:00" and "14:30"
    When user select survey time "12:00"
    And user select survey time period "Pagi"
    Then user verify displayed time slots switch to period "Pagi"
    And user verify displayed time slots are between "08:00" and "10:30"

  @TEST_LIMO-9414
  Scenario: [Survey][Tenant] Phone number input validation
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost P2 With Sameday Active | Kost P2 With Sameday Active |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Tanggal Lain"
    And user open survey date picker on form survey
    And user select date "available" on survey form
    And user select survey time period "Pagi"
    And user select survey time "08:00"
    And user check TnC agreement checkbox on survey form
    Then user validate multiple phone numbers:
      | phone_input      | is_valid | error_msg                          |
      |                  | No       | Field required                     |
      | 0812345678       | Yes      | -                                  |
      | 081234567890123  | Yes      | -                                  |
      | 08123456         | No       | Mohon masukkan nomor HP yang valid |
      | 0812345678901234 | No       | Mohon masukkan nomor HP yang valid |
      | 628123456789     | No       | Mohon diawali dengan 08            |
      | 12345678901      | No       | Mohon diawali dengan 08            |

  @TEST_LIMO-9415 @continue
  Scenario: [Survey][Tenant] T&C checkbox on survey form and pop up confirmation
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 081197878846 | 081197878846 | Perempuan |
    And tenant search kost then go to kost details:
      | kost name stag              | kost name prod              |
      | Kost P2 With Sameday Active | Kost P2 With Sameday Active |
    And user dismiss FTUE booking benefit
    And user dismiss promo ngebut pop up
    And user click chat in kos detail
    And user tap on survey kost btn on detail chatroom
    And user select survey date type "Tanggal Lain"
    And user open survey date picker on form survey
    And user select date "available" on survey form
    And user select survey time period "Pagi"
    And user select survey time "08:00"
    And user fill phone number "081197878846" on survey form
    # Verify T&C link
    Then user verify TnC link text is "Kebijakan Privasi Mamikos"
#    When user click on TnC link
#    Then user verify TnC link opens "Kebijakan Privasi Mamikos Help Center"
#    And user verify TnC section is scrollable not sticky
    # Verify button state based on checkbox
    Then user verify ajukan survey btn is disable on survey form
    When user check TnC agreement checkbox on survey form
    Then user verify ajukan survey btn is enable on survey form
    # Submit and verify popup
    And user tap on ajukan survey btn on form
    Then user verify popup confirmation is visible
    And user verify popup confirmation heading is "Pastikan Datamu Benar"
    When user confirm popup ajukan survey if appear
    # Verify chatroom result
    And user verify P2 autoreply message appears

  @TEST_LIMO-9415
  Scenario: cleanup survey @TEST_LIMO-9415
    # Cleanup - batalkan survey for next run
    And user batalkan survey if the survey already submitted
