@regression @LIMO2 @listing-monetization
Feature: Check maksimum discount mamipoin owner at payment page

  @TEST_LIMO-64 @continue
  Scenario: [Owner][Payment[Mamipoin Owner] Check maksimum discount mamipoin owner when paid GP 1 or Gp 2
    Given user go to mamikos homepage
    When user login as owner:
      | phone stag | phone prod | password |
      | 082233545504 | 0          | 12345678 |

    And user click mamipoin in owner's menu
    Then user verify MamiPoin onboarding is appear
    And user verify point is > 29000

    When user wants to subscribe Goldplus 1
    And user click toggle mamipoin
    Then user see total potongan mamipoin 29000

    #scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "082233545504"

  Scenario: [Owner][Payment[Mamipoin Owner] Check maksimum discount mamipoin owner when paid Gp 2
    Given owner navigates to "/"
    When user click mamipoin in owner's menu
    Then user verify point is > 71500
    When user wants to subscribe Goldplus 2
    And user click toggle mamipoin
    Then user see total potongan mamipoin 71500

 #scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    And user wants to reset Goldplus for owner with phone number "082233545511"

  @TEST_LIMO-65
  Scenario: [Owner][Payment[Mamipoin Owner] Check maksimum discount mamipoin owner when poin < from discount maksimum
    Given user go to mamikos homepage
    Given user login as owner:
      | phone stag | phone prod | password |
      | 082233545511 | 0          | 12345678 |
    And user click mamipoin in owner's menu
    Then user verify MamiPoin onboarding is appear
    * user verify point is < 29000
    When user wants to subscribe Goldplus 1
    And user click toggle mamipoin
    Then user see total potongan mamipoin 5000

    #scenario delete or reset data GP
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                   | email prod                   | password  |
      | automationpman03@mamikos.com | automationpman03@mamikos.com | qwerty123 |
    And user wants to reset Goldplus for owner with phone number "082233545511"
