@SS9
Feature: Landmark

  @TEST_SS-7302
  Scenario Outline: [Web][Bangker][Landmark Data]Admin check main view on Landmark Data Menu
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin bangkerupux navigates landmark data menu
    And admin can see main menu with "<text>"
    Examples:
      | text                |
      | ID                  |
      | Name                |
      | Parent Category     |
      | Category            |
      | Is Show on SRP      |
      | Icon                |
      | Location (lat, lon) |
      | Score               |
      | Subdistrict         |
      | Rooms Count         |
      | Action              |

  @TEST_SS-7303
  Scenario: [Web][Bangker][Landmark Data]Admin check search landmark
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin bangkerupux navigates landmark data menu
    When admin choose search by "id"
    And admin input search with "3"
    And admin click search button
    Then admin can see data with name "Bandanaira Airport"
    When admin choose search by "name"
    And admin input search with "Aek Godang Airport"
    And admin click search button
    Then admin can see data with name "Aek Godang Airport"

  @TEST_SS-7304
  Scenario: [Web][Bangker][Landmark Data]Admin check filtering by category
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin bangkerupux navigates landmark data menu
    When admin choose filter catogory by "Food Stalls"
    And admin click search button
    Then admin can see category with name "Food Stalls"
    When admin choose filter catogory by "Shopping"
    And admin click search button
    Then admin can see category with name "Shopping"
    When admin choose filter catogory by "Mosque"
    And admin click search button
    Then admin can see category with name "Mosque"
    When admin choose filter catogory by "Church"
    And admin click search button
    Then admin can see category with name "Church"
    When admin choose filter catogory by "Pagoda"
    And admin click search button
    Then admin can see category with name "Pagoda"

  @TEST_SS-7305
  Scenario: [Web][Bangker][Landmark Data]Admin check filtering by Is Show on SRP
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin bangkerupux navigates landmark data menu
    When admin choose filter show in srp with "show srp yes"
    And admin click search button
    Then admin can see show in srp with "Yes"
    When admin choose filter show in srp with "show srp no"
    And admin click search button
    Then admin can see show in srp with "No"

  @TEST_SS-7306 @continue
  Scenario: [Web][Bangker][Landmark Data]Admin check remapping button
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    Then admin bangkerupux navigates landmark data menu
    When admin choose search by "name"
    And admin input search with "Rumah Desta"
    And admin click search button
    And admin click on remapping button
    And admin can see success alert remapping
    Then admin can see data with name "57"

  @TEST_SS-7307
  Scenario: [Web][Bangker][Landmark Data]Admin edit landmark
    Then admin bangkerupux navigates landmark data menu
    When admin choose search by "name"
    And admin input search with "Ajamu Banksumut"
    And admin click search button
    And admin clicks on edit button
    Then admin can see edit page
    And admin update score with "100"
    Then admin can see success alert remapping