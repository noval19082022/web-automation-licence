@COOP-5027 @COOP3
Feature: SinggahSini Tenant Tracker Profile Page Filter


  @TEST_COOP-5076 @Automated @web
  Scenario: Filter By Nama Properti
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to tenant communication menu
    And user choose "Nama Penyewa" and input "Adisinggahsini" in the search field on main page
    And user click search button on main page filter
    And user clicks on the tenant name on the first row
    And user choose "Nama Penyewa" and input "Kost Adi Manual" in the search field on main page
    And user click search button on main page filter
    Then user see pagination menu on Detail Tenant is displayed
    And user verify nama property on profile page filter is "Kost Adi Manual"
		
