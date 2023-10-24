@singgahsini @regression @pman @pman-prod

Feature: Kost List
  @TEST_PMAN-3269 @continue
  Scenario: Admin - Verify Component of Page Kost List
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin access menu "Kost List" sub menu of management level
    Then system displaying content of page kost list

  @TEST_PMAN-3268 @continue
  Scenario: Edit Kost Level
    When admin search kost pman "Kost Tobelo Asri Village"
    And admin change level to "Mamikos Goldplus 1 PROMO" on Edit Kost Level
    Then the Level is displaying "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back to Regular
    When admin search kost pman "Kost Tobelo Asri Village"
    And admin change level to "Reguler" on Edit Kost Level
    Then the Level is displaying "Reguler"

  @TEST_PMAN-3263 @continue
  Scenario: Charge by in Kost List
    When admin search kost pman "Kost Tobelo Asri Village"
    And admin clicks on Edit Kost Level
    And admin change charge by to "Room" on Edit Kost Level
    Then charge by "Room" is selected
    #revert back into default data
    When admin change charge by to "Kost" on Edit Kost Level
    Then charge by "Kost" is selected

  @TEST_PMAN-3276 @continue
  Scenario: Edit Room Level
    When admin access menu "Kost List" sub menu of management level
    And admin search kost pman "Kost Tobelo Asri Village"
    And admin clicks on Room List
    And admin search room by room name "RoomAutomate"
    And admin change room level to "Mamikos Goldplus 1 PROMO" on Room List
    Then the room Level is displaying "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back room level
    When admin search room by room name "RoomAutomate"
    And admin change room level to "Regular" on Room List
    Then the room Level is displaying "Regular"

  @TEST_PMAN-3278 @continue
  Scenario: Assign All Rooms
    When admin clicks Assign All button
    And admin change room level to "Mamikos Goldplus 1 PROMO" on Assign All Rooms
    Then all room level is changed to "Mamikos Goldplus 1 PROMO"
    #Scenario: revert back all room to Regular
    When admin clicks Assign All button
    And admin change room level to "Regular" on Assign All Rooms
    Then all room level is changed to "Regular"

  @TEST_PMAN-3287
  Scenario: Verify pagination in Room List
    And admin click page number "2" on Room List
    Then system display Room List page number "2" is active

  @TEST_PMAN-3274
  Scenario Outline: Verify pagination in Kost List
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | password        |
      | admin.automation@mamiteam.com | 4dm!nAutomat10n |
    And admin access menu "Kost List" sub menu of management level
    And admin clicks on page number "<number>" of kost list
    Then system display kost list page number "<number>" is active

    Examples:
      | number |
      | 2      |
      | 3      |
      | 4      |