@SS7 @rewardType
Feature: Reward Type

  @createRewardType @continue @TEST_SS-4250 @TEST_SS-3549
  Scenario: Add Reward Type using existing key and special character
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    When admin access to Reward Type menu
    And admin click button add reward type
    And admin input reward type with :
      | key        | name         |
      | rewardTest | Automation 6 |
    And admin can see error message type with "Key already exist."
    And admin input reward type with :
      | key       | name            |
      | reward!@# | Automation 6!@# |
    And admin can see error message type with "The key may only contain letters, numbers, and dashes."

  @continue @TEST_SS-4251
  Scenario: Add Reward Type
    When admin access to Reward Type menu
    And admin click button add reward type
    And admin input reward type with :
      | key             | name         |
      | automation_key6 | Automation 6 |
    And admin can see error message type with "Key already exist."

  @TEST_SS-4252
  Scenario: edit reward type
    When admin access to Reward Type menu
    And admin click edit button on "107 rewardTest rewart-test-satu"
    And admin input reward type with :
      | key        | name             |
      | rewardTest | rewart-test-satu |
    Then system display success add reward type