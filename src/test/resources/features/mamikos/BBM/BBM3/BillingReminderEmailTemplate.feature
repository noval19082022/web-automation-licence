@regression @billingReminder @BBM3

@TEST_BBM-987 @TEST_BBM-989 @TEST_BBM-985 @TEST_BBM-983
Feature: Billing Reminder - Email Template

  Background: User arrived on Email Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " Email Template" submenu of Billing Reminder Template

  Scenario: user set the initial state to display Billing template Day -1
    When user set the initial state to display Billing template Day "-1"

#  @BBM-987
  Scenario: Delete Template
    When user delete billing Template with content "untuk automation"
    Then user verify delete billing Template with content "untuk automation"

 #  BBM-983
  Scenario: Add Template With Existing Day Period
    Given user create new template:
      | day   | subject                 | content                    |
      | 0     | untuk automation        | untuk automation content   |
    Then user verify cannot create billing reminder template

#    BBM-985
  Scenario: Add Template
    Given user create new template:
      | day     | subject                 | content                    |
      | -1      | untuk automation        | untuk automation content   |
    Then user verify Template subject with "untuk automation"
    Then user verify Template content with "untuk automation content"

#  BBM-989
  Scenario: Edit Template
    Given user edit template:
      | day     | subject                 | content                    |
      | -1      | untuk automation        | untuk automation content   |
    Then user verify Template subject with "untuk automation"
    Then user verify Template content with "untuk automation content"
