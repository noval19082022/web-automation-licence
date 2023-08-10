@regression @billingReminder @BBM3

@TEST_BBM-978 @TEST_BBM-981 @TEST_BBM-979 @TEST_BBM-977
Feature: Billing Reminder - PN Template

  Scenario: User arrived on PN Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " PN Template" submenu of Billing Reminder Template

 # Scenario: user set the initial state to display Billing template Day -1
    When user set the initial state to display Billing template Day "-1"

#  Scenario: Delete Template
    When user delete billing Template with content "untuk automation"
    Then user verify delete billing Template with content "untuk automation"

#  Scenario: Add Template With Existing Day Period
    Given user create new PN template:
      | day     | title                   | content                    |
      | -7      | untuk automation        | untuk automation content   |
    Then user verify cannot create billing reminder template

#  Scenario: Delete Template
    When user delete billing Template with content "untuk automation"
    Then user verify delete billing Template with content "untuk automation"

#  Scenario: Add Template
    Given user create new PN template:
      | day     | title                   | content                    |
      | -1      | untuk automation        | untuk automation content   |
    Then user verify Template subject with "untuk automation"
    Then user verify Template content with "untuk automation content"

#  Scenario: Edit Template
    Given user edit PN template:
      | day     | title                   | content                    |
      | -1      | untuk automation        | untuk automation content   |
    Then user verify Template subject with "untuk automation"
    Then user verify Template content with "untuk automation content"