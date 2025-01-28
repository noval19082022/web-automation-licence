@COOP3
Feature: SinggahSini Tenant Tracker Profile Page


  @SS-4247 @Automated @web @continue
  Scenario: Profile Page Display
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password        |
      | pman@mamiteam.com | pmanM4m1t34m!!  |
    And admin go to tenant communication menu
    And user choose "Nama Penyewa" and input "Adisinggahsini" in the search field on main page
    And user click search button on main page filter
    And user clicks on the tenant name on the first row
    Then user verify search result on profile page bse contains "Adisinggahsini"

  Scenario: Pagination Functionality
    Then user see pagination menu on Detail Tenant is displayed
    When user click pagination number "2"
    Then user will be in the second pagination
		
