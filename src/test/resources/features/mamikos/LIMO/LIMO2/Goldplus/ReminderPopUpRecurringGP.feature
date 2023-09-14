# reminder pop up recurring GP at owner dashboard
@regression @LIMO21 @LIMO2-staging @reminderPopUpRecurringGP
Feature: Reminder Pop Up Recurring GP at owner dashboard

#  Scenario: Scenario Buy GP 1 until paid
#    Given user go to mamikos homepage
#    When user login as owner:
#      | phone stag   | phone prod | password |
#      | 082233545514 | 0          | 12345678 |
#    And owner navigates to "/goldplus/payment"
#    And user click Lihat Tagihan on riwayat
#    Then payment owner success using ovo as payment method

  @TEST_LIMO-2207
  Scenario: [Owner][GP Recurring] Owner see reminder to pay GP recurring  H-7
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user sets recurring for number "082233545514"

