@regression @LIMO2 @goldplusRecurring
# Recurring GPLT
Feature: Goldplus Recurring

  @TEST_LIMO-3526
  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "082233545514"

  @continue @TEST_LIMO-3526
  Scenario: Owner Purchase GP
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag   | phone prod | password |
      | 082233545514 | 0          | 12345678 |
    And user wants to subscribe Goldplus 1
    Then payment owner success using ovo as payment method

  @continue @TEST_LIMO-3527
  Scenario: Login to mamipay
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |

  @continue @TEST_LIMO-3527 @TEST_LIMO-2209
  Scenario Outline: Owner see reminder to pay GP recurring
    When user sets recurring "<days>" for number "082233545514"
    And owner navigates to owner dashboard
    Then owner will see pop up reminder recurring is displayed
    When owner wants to proccess recurring GP
    Then owner will be redirected to invoice recurring
    Examples:
      | days |
      | H7   |
      | H5   |
      | H3   |
      | H1   |

  @continue @TEST_LIMO-3528
  Scenario: [Owner][GP Recurring] Owner want to cancel GP Recurring via pop up reminder
    When user sets recurring "H7" for number "082233545514"
    And owner navigates to owner dashboard
    And owner click "Nanti Saja"
    When owner wants to access goldplus dashboard
    Then owner will be redirected to invoice recurring

  @continue @TEST_LIMO-3529
  Scenario: owner GP recurring wants to extend GP via Notif Center
    And owner navigates to owner dashboard
    When owner wants to extends Goldplus from notif center
    Then owner will be redirected to invoice recurring

  @continue @TEST_LIMO-3530
  Scenario: owner GP recurring wants to extend GP via Chatlist
    And owner navigates to owner dashboard
    When owner wants to extends Goldplus from chatlist
    Then owner will be redirected to invoice recurring

  @continue @TEST_LIMO-3531
  Scenario: owner GP recurring wants to extend GP via Chatroom
    And owner navigates to owner dashboard
    And owner wants to extends Goldplus from chatroom
    Then owner will be redirected to invoice recurring

  @continue @TEST_LIMO-3532
  Scenario: [Owner][GP Recurring] Owner want to extend GP via pop up reminder
    When user sets recurring "H5" for number "082233545514"
    And owner navigates to owner dashboard
    When owner wants to proccess recurring GP
    Then payment owner success using ovo as payment method
    And owner navigates to owner dashboard
    And owner should not be able to see the text "Perpanjang paket Goldplus yuk!"

  @TEST_LIMO-3533
  Scenario: Owner doesn't get recurring reminder pop up
    When user sets recurring "H2" for number "082233545514"
    And owner navigates to owner dashboard
    Then user will see that the text "Perpanjang paket Goldplus yuk!" is displayed

  Scenario: delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "082233545514"
