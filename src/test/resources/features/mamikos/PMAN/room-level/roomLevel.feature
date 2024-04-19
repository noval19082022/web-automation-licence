@regression @pman @pman-prod @roomLevel

Feature: Add and Edit Room Level

  @TEST_PMAN-3254 @continue
  Scenario: Add Room Level with Existing Key
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin go to room level menu
    And admin add room level with existing key "room_level_key"
    Then error message existing key is displayed
    When admin go to room level menu
    Then room level is not created

  @TEST_PMAN-9047
  Scenario: Edit Room Level with Existing Key
    When admin edit room level with existing key "room_level_key"
    Then error message existing key is displayed
    When admin go to room level menu
    And admin search room level "Automation PMAN Existing Key"
    Then the key is not changed

  @TEST_PMAN-3284
  Scenario: Charging fee can't more than 100%
    #Add charging fee > 100%
    Given admin go to mamikos bangkrupux admin
    And admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    When admin go to room level menu
    And admin add room level "Test Charging Fee"
    And set charging fee "200"
    Then show charging fee error message "The charging fee cannot be greater than 100"
    #Edit charging fee > 100%
    When admin go to room level menu
    And admin edit room level "Automation PMAN Existing Key"
    And set charging fee "200"
    Then show charging fee error message "The charging fee cannot be greater than 100"

  @TEST_PMAN-3286 @continue
  Scenario: Update Room Level Without Fill Level Name
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin go to room level menu
    And admin search room level "Automation PMAN"
    And admin edit room level with empty level name
    Then show error message "The name field is required."

  @TEST_PMAN-3282 @continue
  Scenario: Verify Component of Page List Room Level
    When admin go to room level menu
    Then should show room level menu content

  @TEST_PMAN-3266
  Scenario: Verify Pagination in Room Level
    When admin go to room level menu
    And admin go to page "2"
    Then page number "2" is active