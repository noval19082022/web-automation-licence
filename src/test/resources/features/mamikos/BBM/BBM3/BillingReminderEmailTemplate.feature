@regression @billingReminder @BBM3

@TEST_BBM-987 @TEST_BBM-989 @TEST_BBM-985 @TEST_BBM-983
Feature: Billing Reminder - Email Template

  @continue
  Scenario: User arrived on Email Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " Email Template" submenu of Billing Reminder Template

 # Scenario: user set the initial state to display Billing template Day -1
    When user set the initial state to display Billing template Day "-1"

  @continue
    Scenario: Delete Template
    Given admin go to mamikos mamipay admin
    Then user open " Email Template" submenu of Billing Reminder Template
    When user delete billing Template with content "-1 untuk automation"
    Then user verify delete billing Template with content "-1 untuk automation"

  @continue
  Scenario: Add Template With Existing Day Period
    Given admin go to mamikos mamipay admin
    Then user open " Email Template" submenu of Billing Reminder Template
    And user create new template:
      | day    | subject                    | content                       |
      | 0      | 0 untuk automation         | 0 untuk automation content    |
    Then user verify cannot create billing reminder template

  @continue
  Scenario: Add Template
    Given admin go to mamikos mamipay admin
    Then user open " Email Template" submenu of Billing Reminder Template
    And user create new template:
      | day     | subject                     | content                       |
      | -1      | -1 untuk automation         | -1 untuk automation content   |
    Then user verify Template subject with "-1 untuk automation"
    Then user verify Template content with "-1 untuk automation content"

  @continue
  Scenario: Edit Template
    Given admin go to mamikos mamipay admin
    Then user open " Email Template" submenu of Billing Reminder Template
    And user edit template:
      | day     | subject                   | content                     |
      | 0       | 0 untuk automation        | 0 untuk automation content  |
    Then user verify Template subject with "0 untuk automation"
    Then user verify Template content with "0 untuk automation content"