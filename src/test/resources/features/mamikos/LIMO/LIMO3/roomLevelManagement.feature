@regression @LIMO3 @listing-monetization @roomLevelManagement @levelManagement

Feature: Room Level Management

  @TEST_LIMO-3260 @continue
  Scenario: [Admin] Add Room Level
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                   | email prod                   |password  |
      | Automation.pw1@mamikos.com   | Automation.pw1@mamikos.com   |qwerty123 |
    And admin go to room level menu
    And admin click on add "Room" level
    And admin fill out form "add room" level "Room Level Testing"
    Then verify success "add room" message is displayed
    When admin search "room" level
    Then verify the "room" level "Room Level Testing" already displayed

  @TEST_LIMO-3261 @continue
  Scenario: [Admin] Edit Room Level
    When admin click "edit" on kost level
    And admin fill out form "edit room" level "Room Level Testing Edited"
    Then verify success "edit room" message is displayed
    When admin search "room" level
    Then verify the "room" level "Room Level Testing Edited" already displayed

  @TEST_LIMO-3262
  Scenario: [Admin] Delete Room Level
    When admin click "delete" on kost level
    Then verify success "delete room" message is displayed