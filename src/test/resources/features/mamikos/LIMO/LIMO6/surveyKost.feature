@regression @surveyTenantP1 @LIMO6

Feature: Survey Tenant

  @TEST_SS-3591 @continue
  Scenario: Submit survei from chat template on Kost Detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag    | phone prod | password  |
      | 0811978788416 | 0812000005 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user tap on survey kost btn on detail chatroom
    # NEW FLOW - Select survey date type
    And user select survey date type "Tanggal Lain"
    And user open survey date picker on form survey
    And user select date "7" on survey form
    # NEW FLOW - Select survey time (2 steps: period + specific time)
    And user select survey time period "Pagi"
    And user select survey time "08:00"
    # NEW FLOW - Fill phone number
    And user fill phone number "0811978788416" on survey form
    # NEW FLOW - Check TnC checkbox
    And user check TnC agreement checkbox on survey form
    # Submit survey
    And user tap on ajukan survey btn on form
    # NEW FLOW - Confirm popup if appear (only for P2)
    And user confirm popup ajukan survey if appear
    # Verify
    And user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    Then chat room appear with latest message "Survei Diterima"

#  @TEST_LIMO-9323 @continue
#  Scenario: Submit survei hari ini from chat template on Kost Detail
#    Given user go to mamikos homepage
#    When user login as tenant via phone number:
#      | phone stag    | phone prod | password  |
#      | 0811978788416 | 0812000005 | qwerty123 |
#    And user click on chat button in top bar tenant home page
#    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
#    And user tap on survey kost btn on detail chatroom
#    # NEW FLOW - Select "Survei Hari Ini"
#    And user select survey date type "Survei Hari ini"
#    Then user verify survey date on form is "today"
#    # NEW FLOW - Select survey time (2 steps: period + specific time)
#    And user select survey time period "Pagi"
#    And user select survey time "08:00"
#    # NEW FLOW - Fill phone number
#    And user fill phone number "0811978788416" on survey form
#    # NEW FLOW - Check TnC checkbox
#    And user check TnC agreement checkbox on survey form
#    # Submit survey
#    And user tap on ajukan survey btn on form
#    # NEW FLOW - Confirm popup if appear (only for P2)
#    And user confirm popup ajukan survey if appear
#    # Verify
#    And user go to mamikos homepage
#    And user click on chat button in top bar tenant home page
#    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
#    Then chat room appear with latest message "Survei Diterima"
#
#    ## currently reschedule survey is disable
##  @TEST_SS-3645 @continue
##  Scenario: Reschedule survei from chat room
##    When user go to mamikos homepage
##    And user click on chat button in top bar tenant home page
##    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
##    And user click on Ubah Jadwal button
##    And user open time survey option on form survey
##    Then user select survey available time
##    Then chat room appear with latest message "Survei Diterima"
#
#  @TEST_SS-3592
#  Scenario: cancel survei from chat template on Kost Detail
#    When user go to mamikos homepage
#    And user click on chat button in top bar tenant home page
#    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
#    And user batalkan survey if the survey already submitted
#
#  @TEST_SS-3644 @continue
#  Scenario: Submit Survey for Uncontrolled Property
#    When user go to mamikos homepage
#    And tenant redirect to kost details:
#      | kost path stag                                       | kost path prod               |
#      | kost-bantul-kost-campur-eksklusif-kos-loyal-kretek-1 | Kos DC BAR Automation Tipe A |
#    And user click chat in kos detail
#    Then question "Saya ingin survei dulu" is not displayed
#
#  @TEST_SS-3984 @continue
#  Scenario: Survey Fase and Status for Controlled Property
#    Given admin go to pms singgahsini
#    When admin login pms :
#      | email             | password       |
#      | pman@mamiteam.com | pmanM4m1t34m!! |
#    And admin go to tenant communication menu
#    And user choose "Nama Properti" and input "Kost Adi Auto SinggahSini Tobelo Halmahera Utara" in the search field on main page
#    Then user verify nama property on main page filter is "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
#
#  @TEST_SS-3948
#  Scenario: Survey Fase and Status for Uncontrolled Property
#    When admin go to tenant communication menu
#    And user choose "Nama Properti" and input "Kos Loyal Kretek" in the search field on main page
#    Then user verify nama property on main page filter is not "Kos Loyal Kretek"