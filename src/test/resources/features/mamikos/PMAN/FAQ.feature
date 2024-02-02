@regression @pman @pman-prod @faq

Feature: FAQ

  @TEST_PMAN-3252 @continue
  Scenario: Search Question and Answer in FAQ
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin go to FAQ menu
    #Search Question
    And admin search "upgrade" in FAQ "Question"
    Then FAQ "Question" result is displayed
    #Search Answer
    When admin search "keuntungan" in FAQ "Answer"
    Then FAQ "Answer" result is displayed

  @TEST_PMAN-3283 @continue
  Scenario: Add FAQ
    #Delete FAQ PMAN AT if any
    When admin search "PMAN AT" in FAQ "Question"
    And admin deletes level faq
    #Add Level FAQ
    When admin adds level faq
    And admin search "PMAN AT" in FAQ "Question"
    Then new Level FAQ is displayed

  @TEST_PMAN-3253
  Scenario: Delete FAQ
    When admin deletes level faq
    Then alert message is displayed
    When admin search "PMAN AT" in FAQ "Question"
    Then new Level FAQ is not displayed

  @TEST_PMAN-3290
  Scenario: Verify FAQ Content
    Given admin go to mamikos bangkrupux admin
    When admin login to bangkrupux:
      | email stag                    | email prod                    | password        |
      | automationpman01@mamikos.com  | automationpman01@mamikos.com  | qwerty123       |
    And admin go to FAQ menu
    Then show manage level FAQ content
