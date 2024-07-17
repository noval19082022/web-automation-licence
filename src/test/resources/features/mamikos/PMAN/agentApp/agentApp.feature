@regression @pman @agentApp

Feature: Agent App

  @TEST_SS-639 @pman-prod @continue
  Scenario: Table Agent Contains Role Column
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin goes to Agent App menu
    Then agent column is contains
      | ID        |
      | Code      |
      | Type      |
      | Agent     |
      | Role      |
      | Is active |
      | Action    |

  @TEST_SS-649 @continue
  Scenario: Check is_active Yes Value When User in Edit Page
    When admin checks is active "Yes" status in Edit page for "Automation PMAN Yes" agent
    Then is active status in Edit page is "Yes"

  @TEST_SS-736
  Scenario: Check is_active No Value When User in Edit Page
    When admin goes to Agent App menu
    And admin checks is active "No" status in Edit page for "Automation PMAN No" agent
    Then is active status in Edit page is "No"