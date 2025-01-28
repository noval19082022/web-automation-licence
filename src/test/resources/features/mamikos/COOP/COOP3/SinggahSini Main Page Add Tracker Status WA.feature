@COOP3
Feature: SinggahSini Main Page Add Tracker Status WA


  @SS-4239 @continue
  Scenario: Add Track Status Chat WA on existing user
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "BSE" in the search field on main page
    And user click search button on main page filter
    And user click action Button on tenant communication page
    And user set the initial state to "Tambah track status chat WA"
    And user filled "prioritaskan" in note field tracker WA status
    And user click Tambah in tracker status WA
    Then user verify search result on main page bse contains Prioritaskan

  Scenario: Add track WA status on existing row
    When user choose "Nama Properti" and input "BSE" in the search field on main page
    And user click search button on main page filter
    And user click action Button on tenant communication page
    And user set the initial state to "Tambah track status chat WA"
    And user filled "prioritaskan" in note field tracker WA status
    And user click Tambah in tracker status WA
    Then success add tracker pop-up appear and "Whatsapp" Status is updated

  Scenario: Tanya Alamat via map is tracked on BSE Tenant Tracker
    Given user go to mamikos homepage
    When user login as tenant via phone number:
      | phone stag   | phone prod   | password  |
      | 085242455775 | 081197878846 | qwerty123 |
    And tenant redirect to kost details:
      | kost path stag                                                       |
      | kost-bantul-kost-campur-murah-kost-apik-serayu-utara-tipe-a-kretek-2 |
    And tenant dismiss FTUE booking benefit
    And user want to ask kost address
    #check in Tenant Tracker
    When admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin go to tenant communication menu
    When user choose "Nama Penyewa" and input "Automation CRM" in the search field on main page
    And user click search button on main page filter
    Then user verify search result on main page bse contains "Tanya Alamat"