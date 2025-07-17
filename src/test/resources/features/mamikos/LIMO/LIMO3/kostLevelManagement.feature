@regression @LIMO3 @listing-monetization @levelManagement @DONEMIGRATINGTONEWBOARD

Feature: Kost Level Management

  @TEST_LIMO-102 @continue @kostLevelManagement
  Scenario: [Admin][Kost Level Management] Add Kost Level
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to kost level menu
    And admin click on add "Kost" level
    And admin fill out form "add kost" level "Kost Level Testing"
    And admin "confirm" save kost level data pop up confirmation
    Then verify pop up message "Level successfully added." success added
    When admin search "kost" level
    Then verify the "kost" level "Kost Level Testing" already displayed

  @TEST_LIMO-101 @continue @kostLevelManagement
  Scenario: Edit Kost Level
    And admin search kost level "Kost Level Testing"
    When admin click "edit" on kost level
    And admin fill out form "edit kost" level "Kost Level Testing Edited"
    And admin "confirm" save kost level data pop up confirmation
    Then verify pop up message "Level successfully updated." success added
    When admin search "kost" level
    Then verify the "kost" level "Kost Level Testing Edited" already displayed

  @TEST_LIMO-100 @kostLevelManagement
  Scenario: Delete Kost Level
    When admin click "delete" on kost level
    Then verify success "delete" message is displayed