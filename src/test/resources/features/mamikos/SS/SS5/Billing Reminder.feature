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
      | day | WATemplate                |
      | -7  | recurringbooking_day_min_7 |
    Then user verify Template subject with "recurringbooking_day_min_7"

		#  Scenario: Edit Template
    Given user edit WhatsApp template:
      | day | WATemplate            |
      | -7  | inform_manual_invoice |
    Then user verify Template subject with "inform_manual_invoice"

		#  Scenario: Delete Template
    When user delete billing Template with content "inform_manual_invoice"
    Then user verify delete billing Template with content "inform_manual_invoice"
