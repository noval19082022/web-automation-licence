@COOP-5027 @COOP3
Feature: SinggahSini Tenant Tracker Main Page Filter


  @SS-4245 @continue
  Scenario: Filter By Nama Penyewa
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password     |
      | pman@mamiteam.com | pmanM4m1t34m |
    And admin go to tenant communication menu
    And user choose "Nama Penyewa" and input "Adisinggahsini" in the search field on main page
    And user click search button on main page filter
    Then user verify nama penyewa on main page filter is "Adisinggahsini"

   @continue
  Scenario: Filter By No HP Penyewa
    When user choose "No. HP Penyewa" and input "0890867321213" in the search field on main page
    And user click search button on main page filter
    Then user verify nama penyewa on main page filter is "Adisinggahsini"

  Scenario: Filter By Nama Properti
    When user choose "Nama Properti" and input "Kost Adi Auto SinggahSini Tobelo Halmahera Utara" in the search field on main page
    And user click search button on main page filter
    Then user verify nama property on main page filter is "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
		
