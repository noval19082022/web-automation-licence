@regression @billingReminder @BBM3

Feature: Billing Reminder - WhatsApp Template

  Scenario: User arrived on WhatsApp Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " Whatsapp Template" submenu of Billing Reminder Template

 # Scenario: user set the initial state to display Whatsapp template Day 3
    When user set the initial state to display Billing template Day "3" "42"

#  Scenario: Delete Template
    When user delete billing Template with content "recurringbooking_voucher_d_plus_1_update"
    Then user verify delete billing Template with content "recurringbooking_voucher_d_plus_1_update"

#  Scenario: Add Template With Existing Day Period
    Given user create new WhatsApp template:
      | day     | WATemplate  |
      | -1      | 40          |
    Then user verify cannot create billing reminder template

#  Scenario: Add Template
    Given user create new WhatsApp template:
      | day     | WATemplate  |
      | 0      | 42          |
    Then user verify Template subject with "recurringbooking_voucher_d_plus_1_update"

#  Scenario: Edit Template
    Given user edit WhatsApp template:
      | day     | WATemplate  |
      | 0      | 42          |
    Then user verify Template subject with "recurringbooking_voucher_d_plus_1_update"