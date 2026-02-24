@SS8
Feature: [Loyalty Reward Management][Reward List]Reward List Management page display

  @TEST_SS-3513 @continue
  Scenario: Reward List Management page display
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And user access to Reward List menu
    Then system display Reward List Management page
    When user filter reward name "Reward Automation"
    And user click button filter reward
    And user click button update reward
    And user click checkbox Active
    Then user click button update reward on page detail reward
    And system display success add reward type

  @TEST_SS-3492
  Scenario: Reward status Active
    Given user click Add Reward button
    When user fill required field with correct value
    And user click checkbox Active
    And user submit Reward
    Then system display success add reward type
