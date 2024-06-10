@COOP3
Feature: SinggahSini Main Page Add Tracker Status WA


  @TEST_COOP-5038 @Automated @web @continue
  Scenario: Add Track Status Chat WA on existing user
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "BSE" in the search field on main page
    And user click search button on main page filter
    And user click action Button on tenant communication page
    And user set the initial state to "Tambah track status chat WA"
    And user filled "prioritaskan" in note field tracker WA status
    And user click Tambah in tracker status WA
    Then user verify search result on main page bse contains Prioritaskan

  @TEST_BBM-461 @continue
  Scenario: Add track WA status on existing row
    When user choose "Nama Properti" and input "BSE" in the search field on main page
    And user click search button on main page filter
    And user click action Button on tenant communication page
    And user set the initial state to "Tambah track status chat WA"
    And user filled "prioritaskan" in note field tracker WA status
    And user click Tambah in tracker status WA
    Then success add tracker pop-up appear and "Whatsapp" Status is updated

  @TEST_BBM-463
  Scenario: Tanya Alamat via map is tracked on BSE Tenant Tracker
    When user choose "Nama Penyewa" and input "Noval" in the search field on main page
    And user click search button on main page filter
    Then user verify search result on main page bse contains "Terbayar Lunas"
		
