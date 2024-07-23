@regression @LIMO1 @LIMO1-staging @DONEMIGRATINGTONEWBOARD
Feature: Chat Experiment

  @TEST_LIMO-3289 @continue
  Scenario: CRUD owner chat experiment
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | qaeautomation3@mamikos.com | laksana@mamikos.com        | qwerty123 |
    And user access menu owner chat experiment
    And user clicks on button add owner
    And user add new owner id "99452469"
    And user search user id "99452469"
    Then verify user id "99452469" was added
    When user delete user id
    And user search user id "99452469"
    Then verify user id "99452469" was deleted

  @continue
  Scenario: Cancel add user id
    When user clicks on button add owner
    Then user can click close button on popup

  Scenario: Bulk Add
    When user clicks on button Bulk Add
    And user upload file owner csv
    And user search user id "99452469"
    Then verify user id "99452469" was added
    When user delete user id
    And user search user id "99452469"
    Then verify user id "99452469" was deleted