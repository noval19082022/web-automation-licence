@regression @billingReminder @BBM3

@TEST_BBM-988 @TEST_BBM-984 @TEST_BBM-982 @TEST_BBM-980
Feature: Billing Reminder - SMS Template

  Background: User arrived on SMS Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " SMS Template" submenu of Billing Reminder Template

  Scenario: user set the initial state to display SMS template Day -5
    When user set the initial state to display Billing template Day "-5"

#  BBM-988
  Scenario: Delete Template
    When user delete billing Template with content "untuk automation"
    Then user verify delete billing Template with content "untuk automation"

#  BBM-984
  Scenario: Add Template With Existing Day Period
    Given user create new SMS template:
      | day     | text                    |
      | -1      | untuk automation        |
    Then user verify cannot create billing reminder template

#  BBM-980
  Scenario: Add Template
    Given user create new SMS template:
      | day     | text                    |
      | -5      | untuk automation        |
    Then user verify Template subject with "untuk automation"

#  BBM-982
  Scenario: Edit Template
    Given user edit SMS template:
      | day     | text                    |
      | -5      | untuk automation        |
    Then user verify Template subject with "untuk automation"