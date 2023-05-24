@regression @billingReminder @BBM3

Feature: Billing Reminder - WhatsApp Template

  Background: User arrived on WhatsApp Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " Whatsapp Template" submenu of Billing Reminder Template

  Scenario: user set the initial state to display Whatsapp template Day -5
    When user set the initial state to display Billing template Day "-5" "42"

  @deleteWATemplate @TEST_BBM-975
  Scenario: Delete Template
    When user delete billing Template with content "recurringbooking_voucher_d_plus_1_update"
    Then user verify delete billing Template with content "recurringbooking_voucher_d_plus_1_update"

  @addWATemplateWithExistingDayPeriod @TEST_BBM-990
  Scenario: Add Template With Existing Day Period
    Given user create new WhatsApp template:
      | day     | WATemplate  |
      | -1      | 40          |
    Then user verify cannot create billing reminder template

  @addWATemplate @TEST_BBM-986
  Scenario: Add Template
    Given user create new WhatsApp template:
      | day     | WATemplate  |
      | -5      | 42          |
    Then user verify Template subject with "recurringbooking_voucher_d_plus_1_update"

  @editWATemplate @TEST_BBM-976
  Scenario: Edit Template
    Given user edit WhatsApp template:
      | day     | WATemplate  |
      | -5      | 42          |
    Then user verify Template subject with "recurringbooking_voucher_d_plus_1_update"