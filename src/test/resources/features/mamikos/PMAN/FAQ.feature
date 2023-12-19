@regression @pman @pman-prod @faq

Feature: FAQ

  @TEST_PMAN-3252
  Scenario: Search Question and Answer in FAQ
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin go to FAQ menu
    #Search Question
    And admin search "level" in FAQ "Question"
    Then FAQ "Question" result "level" is displayed
    #Search Answer
    And admin search "Upgrade" in FAQ "Answer"
    Then FAQ "Answer" result "Upgrade" is displayed