@SS5
Feature: SinggahSini Tenant Tracker Main Page Reset Filter


  @SS-4246 @continue
  Scenario: Reset button On filter Page
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to tenant communication menu
    And user choose "Survei" on filter tahapan and "Diajukan" on filter status
    And user click on terapkan button
    And user click search button on main page filter
    And user click reset button in PMS Admin
    Then user has reset the filter

  Scenario: Reset Filter on Filter Menu
    When user choose "Nama Properti" and input "Kost Adi Auto Regular" in the search field on main page
    And user click search button on main page filter
    Then user verify nama property on main page filter is "Kost Adi Auto Regular"
    When user click reset button in PMS Admin
    Then user verify nama property on main page filter is not "Kost Adi Auto Regular"
		
