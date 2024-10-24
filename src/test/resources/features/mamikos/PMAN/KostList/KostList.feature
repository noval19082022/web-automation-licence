@singgahsini @regression @pman @pman-prod

Feature: Kost List
  @TEST_SS-592 @continue
  Scenario: Admin - Verify Component of Page Kost List
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin access menu "Kost List" sub menu of management level
    Then system displaying content of page kost list

  @TEST_SS-595 @continue
  Scenario: Edit Kost Level
    When admin search kost by name "Kost Tobelo Asri Village"
    And admin change level to "Mamikos Goldplus 1 PROMO" on Edit Kost Level
    Then the Level is displaying "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back to Regular
    When admin search kost by name "Kost Tobelo Asri Village"
    And admin change level to "Reguler" on Edit Kost Level
    Then the Level is displaying "Reguler"

  @TEST_SS-577 @continue
  Scenario: Charge by in Kost List
    When admin search kost by name "Kost Tobelo Asri Village"
    And admin clicks on Edit Kost Level
    And admin change charge by to "Room" on Edit Kost Level
    Then charge by "Room" is selected
    #revert back into default data
    When admin change charge by to "Kost" on Edit Kost Level
    Then charge by "Kost" is selected

  @TEST_SS-561 @continue
  Scenario: Edit Room Level
    When admin access menu "Kost List" sub menu of management level
    And admin search kost by name "Kost Tobelo Asri Village"
    And admin clicks on Room List
    And admin search room by room name "RoomAutomate"
    And admin change room level to "Mamikos Goldplus 1 PROMO" on Room List
    Then the room Level is displaying "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back room level
    When admin search room by room name "RoomAutomate"
    And admin change room level to "Regular" on Room List
    Then the room Level is displaying "Regular"

  @TEST_SS-564 @continue
  Scenario: Assign All Rooms
    When admin clicks Assign All button
    And admin change room level to "Mamikos Goldplus 1 PROMO" on Assign All Rooms
    Then all room level is changed to "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back all room to Regular
    When admin clicks Assign All button
    And admin change room level to "Regular" on Assign All Rooms
    Then all room level is changed to "Regular"

  @TEST_SS-569
  Scenario: Verify pagination in Room List
    And admin click page number "2" on Room List
    Then system display Room List page number "2" is active

  @TEST_SS-596
  Scenario Outline: Verify pagination in Kost List
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin access menu "Kost List" sub menu of management level
    And admin clicks on page number "<number>" of kost list
    Then system display kost list page number "<number>" is active

    Examples:
      | number |
      | 2      |
      | 3      |
      | 4      |

  @TEST_SS-568 @continue
  Scenario: Search Kost List by Name
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin access menu "Kost List" sub menu of management level
    #serch by kost name
    When admin search kost by name "Tobelo Asri"
    Then show result kost "Tobelo Asri"

  @TEST_SS-636 @continue
  Scenario: Search Kost List by Owner Name
    Given admin access menu "Kost List" sub menu of management level
    #serach by owner name
    When admin search kost by owner name "Yudha Chandra"
    Then show all kost belongs to owner "Yudha Chandra"

  @TEST_SS-650 @continue
  Scenario: Search Kost List by Owner Phone Number
    Given admin access menu "Kost List" sub menu of management level
    #search by owner phone number
    When admin search kost by owner phone number "085947715987"
    Then show all kost belongs to owner phone number "085947715987"

  @TEST_SS-580
  Scenario: Search Kost List by Multiple Filter
    When admin access menu "Kost List" sub menu of management level
    And admin search kost by name "Kost Singgahsini Kedai Kopi Tipe B Halmahera Utara"
    And admin search kost by owner name "Okta BSE"
    And admin search kost by owner phone number "081390799096"
    And admin search kost by level "SinggahSini" on Kost List Table
    Then show result kost "Kost Singgahsini Kedai Kopi Tipe B Halmahera Utara"
    And show all kost belongs to owner "Okta BSE"
    And show all kost belongs to owner phone number "081390799096"
    And show all kost belongs to level "SinggahSini"