@COOP3
Feature: SinggahSini Tenant Tracker Main Page Button FollowUp


  @SS-4244 @Automated @web
  Scenario: Action Button Tandai Belum Follow Up
    Given admin go to pms singgahsini
    When admin login pms :
      | email             | password       |
      | pman@mamiteam.com | pmanM4m1t34m!! |
    And admin go to tenant communication menu
    And user choose "Nama Properti" and input "BSE" in the search field on main page
    And user click search button on main page filter
    And user click action Button on tenant communication page
		#   Set the initial state to belum follow up
    And user set the initial state to "Tandai belum follow-up"
		#   Set to sudah follow up
    And user click action Button on tenant communication page
    And user set the initial state to "Tandai sudah follow-up"
    And user click action Button on tenant communication page
    Then user verify search result on main page bse contains "Tandai belum follow-up"
    When user click action Button on tenant communication page
    And user set the initial state to "Tandai belum follow-up"
    When user click action Button on tenant communication page
    Then user verify search result on main page bse contains "Tandai sudah follow-up"
		
