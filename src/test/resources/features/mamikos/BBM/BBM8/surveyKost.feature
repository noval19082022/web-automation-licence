@regression @surveyTenant @BBM8

Feature: Survey Tenant
  @TEST_COOP-2516
  Scenario: Submit survei from chat template on Kost Detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321216 | 08100000622 | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini"
    And user batalkan survey if the survey already submitted
    And user input time survey "10:00"
    And user click on "Kirim form" button
    Then chat room appear with latest message "Terima Kasih, Kak. :) Form survei kakak sudah kami terima. Tim kami akan segera menghubungi kakak melalui WhatsApp."

  @TEST_COOP-2570
  Scenario: Reschedule survei from chat room
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321216 | 08100000622 | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini"
    And user change schedule survey if the survey already submitted
    And user input time survey "8:00"
    And user click on Ubah Jadwal button
    Then chat room appear with latest message "Terima Kasih, Kak. :) Form survei kakak sudah kami terima. Tim kami akan segera menghubungi kakak melalui WhatsApp."

  @TEST_COOP-2517
  Scenario: cancel survei from chat template on Kost Detail
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321216 | 08100000622 | mamikosqa123 |
    And user click on chat button in top bar tenant home page
    And user click "Kost Adi Auto SinggahSini"
    And user batalkan survey if the survey already submitted
    Then chat room appear with latest message "Survei Kost Adi Auto SinggahSini Tobelo Halmahera Utara dibatalkan."

  @TEST_COOP-2569
  Scenario: Submit Survey for Uncontrolled Property
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag  | phone prod  | password  |
      | 0890867321216 | 08100000622 | mamikosqa123 |
    And user search for Kost with name "Kos Loyal Kretek" and selects matching result
    And user click chat in kos detail
    Then question "Saya ingin survei dulu" is not displayed

  @TEST_COOP-2909
  Scenario: Survey Fase and Status for Controlled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "Kost Adi Auto SinggahSini" in the search field on main page
    Then user verify nama property on main page filter is "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"

  @TEST_COOP-2873
  Scenario: Survey Fase and Status for Uncontrolled Property
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password      |
      | pman@mamiteam.com | pmanM4m1t34m  |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "Kos Loyal Kretek" in the search field on main page
    Then user verify nama property on main page filter is not "Kos Loyal Kretek"