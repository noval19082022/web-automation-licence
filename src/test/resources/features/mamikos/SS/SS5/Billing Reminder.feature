@SS5
Feature: Billing Reminder

  @SS-5044 @TESTSET_COOP-4944 @Automated @web
  Scenario: User arrived on PN Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " PN Template" submenu of Billing Reminder Template

		#  Scenario: Add Template With Existing Day Period
    Given user create new PN template:
      | day | title                                    | content                                                   |
      | -1  | Pake Mamikos, bayar kos bisa di mana aja | Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini |
    Then user verify cannot create billing reminder template
		
		#  Scenario: Delete Template
    When user delete billing Template with content "Pake Mamikos, bayar kos bisa di mana aja"
    Then user verify delete billing Template with content "Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini"
		
		#  Scenario: Add Template
    Given user create new PN template:
      | day | title                                    | content                                                   |
      | -1  | Pake Mamikos, bayar kos bisa di mana aja | Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini |
    Then user verify Template subject with "Pake Mamikos, bayar kos bisa di mana aja"
    Then user verify Template content with "Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini"
		
		#  Scenario: Edit Template
    Given user edit PN template:
      | day | title                                    | content                                                   |
      | -1  | Pake Mamikos, bayar kos bisa di mana aja | Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini |
    Then user verify Template subject with "Pake Mamikos, bayar kos bisa di mana aja"
    Then user verify Template content with "Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini"

     # Scenario: user set the initial state to display Billing template Day -1
    When user set the initial state to display Billing template Day "-1"

		#  Scenario: Delete Template
    When user delete billing Template with content "Pake Mamikos, bayar kos bisa di mana aja"
    Then user verify delete billing Template with content "Buat melanjutkan sewa kos, yuk lakukan pembayaran di sini"

#  @SS-5045 @continue
#  Scenario: User arrived on Email Template page
#    Given admin go to mamikos mamipay admin
#    When admin login to mamipay:
#      | email stag                   | email prod                   | password  |
#      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
#    Then user open " Email Template" submenu of Billing Reminder Template
#
#		 # Scenario: user set the initial state to display Billing template Day -1
#    When user set the initial state to display Billing template Day "-1"

#  @SS-5046 @continue
#  Scenario: Delete Template
#    Given admin go to mamikos mamipay admin
#    Then user open " Email Template" submenu of Billing Reminder Template
#    When user delete billing Template with content "-1 untuk automation"
#    Then user verify delete billing Template with content "-1 untuk automation"
#
#  @SS-5047 @continue
#  Scenario: Add Template With Existing Day Period
#    Given admin go to mamikos mamipay admin
#    Then user open " Email Template" submenu of Billing Reminder Template
#    And user create new template:
#      | day | subject            | content                    |
#      | 0   | 0 untuk automation | 0 untuk automation content |
#    Then user verify cannot create billing reminder template
#
#  @SS-5048 @continue
#  Scenario: Add Template
#    Given admin go to mamikos mamipay admin
#    Then user open " Email Template" submenu of Billing Reminder Template
#    And user create new template:
#      | day | subject             | content                     |
#      | -1  | -1 untuk automation | -1 untuk automation content |
#    Then user verify Template subject with "-1 untuk automation"
#    Then user verify Template content with "-1 untuk automation content"
#
#  @SS-5049
#  Scenario: Edit Template
#    Given admin go to mamikos mamipay admin
#    Then user open " Email Template" submenu of Billing Reminder Template
#    And user edit template:
#      | day | subject            | content                    |
#      | 0   | 0 untuk automation | 0 untuk automation content |
#    Then user verify Template subject with "0 untuk automation"
#    Then user verify Template content with "0 untuk automation content"

#  @SS-5050
#  Scenario: [Billing Reminder] Billing Reminder SMS Template
#    Given admin go to mamikos mamipay admin
#    When admin login to mamipay:
#      | email stag                   | email prod                   | password  |
#      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
#    Then user open " SMS Template" submenu of Billing Reminder Template
#
#		#  Scenario: user set the initial state to display SMS template Day -5
#    When user set the initial state to display Billing template Day "-5"
#
#		#  Scenario: Delete Template
#    When user delete billing Template with content "untuk automation"
#    Then user verify delete billing Template with content "untuk automation"
#
#		#  Scenario: Add Template With Existing Day Period
#    Given user create new SMS template:
#      | day | text             |
#      | 0   | untuk automation |
#    Then user verify cannot create billing reminder template
#
#		#  Scenario: Add Template
#    Given user create new SMS template:
#      | day | text             |
#      | -5  | untuk automation |
#    Then user verify Template subject with "untuk automation"
#
#		#  Scenario: Edit Template
#    Given user edit SMS template:
#      | day | text             |
#      | -5  | untuk automation |
#    Then user verify Template subject with "untuk automation"

  @SS-5051
  Scenario: User arrived on WhatsApp Template page
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman01@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    Then user open " Whatsapp Template" submenu of Billing Reminder Template
		
		 # Scenario: user set the initial state to display Whatsapp template Day 3
    When user set the initial state to display Billing template Day "3" "recurringbooking_d_plus_3"
		
		#  Scenario: Add Template With Existing Day Period
    Given user create new WhatsApp template:
      | day | WATemplate                |
      | 3   | recurringbooking_d_plus_3 |
    Then user verify cannot create billing reminder template

		#  Scenario: Delete Template
    When user delete billing Template with content "recurringbooking_d_plus_3"
    Then user verify delete billing Template with content "recurringbooking_d_plus_3"
		#  Scenario: Add Template

    Given user create new WhatsApp template:
      | day | WATemplate                 |
      | -7  | recurringbooking_d_minus_7 |
    Then user verify Template subject with "recurringbooking_d_minus_7"

		#  Scenario: Edit Template
    Given user edit WhatsApp template:
      | day | WATemplate            |
      | -7  | inform_manual_invoice |
    Then user verify Template subject with "inform_manual_invoice"

		#  Scenario: Delete Template
    When user delete billing Template with content "inform_manual_invoice"
    Then user verify delete billing Template with content "inform_manual_invoice"
