@BBM8 @regression
Feature: Search Data Tenant on Bangkerupux Admin

  @continue @TEST_BBM-1157
  Scenario: Search by Registered Phone Number
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini"
    And admin fill the input field on booking form with:
      | search by       | value         |
      | by Phone Number | 082245501000  |
    And admin click search button on booking now
    And admin click next button on booking now
    Then admin should be in "Duration" form step

  @TEST_BBM-1158
  Scenario: Search By Not Registered Phone Number
    When admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini"
    And admin fill the input field on booking form with:
      | search by       | value         |
      | by Phone Number | 087797740000  |
    And admin click search button on booking now
    Then admin verify dialog alert text on form booking is "User not found"

  @continue @TEST_BBM-1189
  Scenario: Search By Registered Name
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini"
    And admin fill the input field on booking form with:
      | search by       | value          |
      | by Name         | adiSinggahSini |
    And admin click search button on booking now
    And admin click next button on booking now
    Then admin should be in "Duration" form step

  @TEST_BBM-1188
  Scenario: Search By Not Registered Name
    When admin go to data booking menu
    And admin click booking now button
    And admin select room with kost name "Kost Adi Auto SinggahSini"
    And admin fill the input field on booking form with:
      | search by       | value           |
      | by Name         | DhiandraAdithya |
    And admin click search button on booking now
    Then admin verify dialog alert text on form booking is "User not found"