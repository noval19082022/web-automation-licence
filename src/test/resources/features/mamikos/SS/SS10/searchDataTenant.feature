@SS8 @regression
Feature: Search Data Tenant on Bangkerupux Admin

  @continue @TEST_SS-3968
  Scenario: Search by Registered Phone Number
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And admin fill the input field on booking form with:
      | search by       | value        |
      | by Phone Number | 082245501000 |
    And admin click search button on booking now
    And admin click next button on booking now
    Then admin should be in "Duration" form step

  @TEST_SS-3970
  Scenario: Search By Not Registered Phone Number
    When admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And admin fill the input field on booking form with:
      | search by       | value        |
      | by Phone Number | 087797740000 |
    And admin click search button on booking now
    Then admin verify dialog alert text on form booking is "User not found"

  @continue @TEST_SS-3892
  Scenario: Search By Registered Name
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And admin fill the input field on booking form with:
      | search by | value          |
      | by Name   | adiSinggahSini |
    And admin click search button on booking now
    And admin click next button on booking now
    Then admin should be in "Duration" form step

  @TEST_SS-3891
  Scenario: Search By Not Registered Name
    When admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini Tobelo Halmahera Utara"
    And admin fill the input field on booking form with:
      | search by | value           |
      | by Name   | DhiandraAdithya |
    And admin click search button on booking now
    Then admin verify dialog alert text on form booking is "User not found"