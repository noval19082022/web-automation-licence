@regression @surveyTenant @BBM8

Feature: Survey Tenant
  @TEST_SS-3591 @continue
  Scenario: Submit survei from chat template on Kost Detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0812000005 | 0812000005 | qwerty123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user batalkan survey if the survey already submitted
    And user input time survey "10:00"
    And user click on "Kirim form" button
    And user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    Then chat room appear with latest message "Terima Kasih, Kak. :) Form survei kakak sudah kami terima. Tim kami akan segera menghubungi kakak melalui WhatsApp."

  @TEST_SS-3645 @continue
  Scenario: Reschedule survei from chat room
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user change schedule survey if the survey already submitted
    And user input time survey "8:00"
    And user click on Ubah Jadwal button
    Then chat room appear with latest message "Terima Kasih, Kak. :) Form survei kakak sudah kami terima. Tim kami akan segera menghubungi kakak melalui WhatsApp."

  @TEST_SS-3592 @continue
  Scenario: cancel survei from chat template on Kost Detail
    When user go to mamikos homepage
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And user batalkan survey if the survey already submitted
    Then chat room appear with latest message "Survei Kost Adi Auto SinggahSini Tobelo Halmahera Utara dibatalkan."
    When user go to mamikos homepage
    Then user logs out as a Tenant user

  @TEST_SS-3644 @continue
  Scenario: Submit Survey for Uncontrolled Property
    When user go to mamikos homepage
    And tenant redirect to kost details:
      | kost path stag                                       | kost path prod               |
      | kost-bantul-kost-campur-eksklusif-kos-loyal-kretek-1 | Kos DC BAR Automation Tipe A |
    And user click chat in kos detail
    Then question "Saya ingin survei dulu" is not displayed

  @TEST_SS-3984 @continue
  Scenario: Survey Fase and Status for Controlled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "Kost Adi Auto SinggahSini Tobelo Halmahera Utara" in the search field on main page
    Then user verify nama property on main page filter is "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"

  @TEST_SS-3948
  Scenario: Survey Fase and Status for Uncontrolled Property
    When admin go to tenant communication menu
    And user choose "Nama Properti" and input "Kos Loyal Kretek" in the search field on main page
    Then user verify nama property on main page filter is not "Kos Loyal Kretek"