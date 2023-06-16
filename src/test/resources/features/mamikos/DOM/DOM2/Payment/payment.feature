Feature: Payment Staging

  @TEST_DOM-623 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] cancel Extend Contract
  # aktivasi kontrak singgahsini
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin want to reactivate invoice by invoice number "69903537/2023/01/43864"

  # extend contract
    And admin search contract by tenant phone number:
      | phone stag   | phone prod  |
      | 089220220105 | 08119787884 |
    And admin search contract by kost level "SinggahSini"
#  this step is comment for whale because the button is hide after ARAC project phase 1 release
#    And admin want to extend contract
#    Then admin will see detail pop up "Custom Extend Contract"

  @TEST_DOM-624 @Automated @web-covered
  Scenario: [BackOffice][Search Contract][Edit Deposit] Search Data Tenant Based On Period Yesterday
    Given admin go to mamikos mamipay admin
    When admin login to mamipay:
      | email stag                 | email prod                 | password  |
      | Automation.pw1@mamikos.com | Automation.pw1@mamikos.com | qwerty123 |
    And admin go to "Search Contract" menu
    And admin want to search contract periode for "Yesterday"
    Then admin redirect to search contract menu detail