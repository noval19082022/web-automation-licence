@regression @LIMO2 @LIMO2-staging
# Recurring GPLT
Feature: Check all entry point Recurring GP

  @TEST_LIMO-2435
  Scenario: [Owner][GP Recurring] Owner see entry point reminder GP recurring

    #scenario Buy GP 1 until paid
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag | phone prod | password |
      | 082233545514 | 0          | 12345678 |
    When user wants to subscribe Goldplus 1
    Then payment owner success using ovo as payment method

    #Scenario wants to create gp recurring
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And admin navigates to Goldplus Testing Tools
    And user sets recurring for number "082233545514"
    Then user will see that the text "Recurring invoice created!" is displayed

    #Scenario owner see reminder pop up recurring at owner dashboard
    And owner navigates to "/"
    Then user will see that the text "Perpanjang paket Goldplus yuk!" is displayed

    #Scenario owner see entry point GP recurring from widget GP
    When owner wants to access goldplus dashboard
    Then owner will see that the text "GoldPlus 1 periode 3 bulan" is displayed

    #Scenario owner GP recurring wants to extend GP via Notif Center
    And owner navigates to "/"
    When owner wants to extends Goldplus from notif center
    Then owner will see that the text "GoldPlus 1 periode 3 bulan" is displayed

    #Scenario owner GP recurring wants to extend GP via Chatlist
    And owner navigates to "/"
    When owner wants to extends Goldplus from chatlist
    Then owner will see that the text "GP1 3 bulan" is displayed

    #Scenario owner GP recurring wants to extend GP via Chatroom
    And owner navigates to "/"
    And owner wants to extends Goldplus from chatroom
    Then owner will see that the text "GP1 3 bulan" is displayed

    #Scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    And admin navigates to Goldplus Testing Tools
    And user wants to reset Goldplus for owner with phone number "082233545514"
    Then user will see that the text "Reset success!" is displayed